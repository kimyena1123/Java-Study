package org.delivery.storeadmin.domain.sse.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@RestController
@RequestMapping("/api/sse")
@RequiredArgsConstructor
public class SseApiController {

    // 로그인한 사용자 ID를 key로 하여 SSE 연결을 저장할 Map
    // 여러 사용자가 동시에 접속하므로, 동시성 문제가 발생하지 않도록 ConcurrentHashMap 사용
    private final Map<String, SseEmitter> userConnection = new ConcurrentHashMap<>();

    /**
     * SSE 연결을 요청하는 클라이언트가 호출하는 엔드포인트
     * - produces = TEXT_EVENT_STREAM : 서버에서 데이터를 스트리밍(실시간 전송)할 수 있도록 설정
     * - 로그인한 사용자의 정보를 AuthenticationPrincipal로 주입받음
     */
    @GetMapping(path = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseBodyEmitter connect(
            @Parameter(hidden = true) //swagger문서에는 이 파라미터 숨김
            @AuthenticationPrincipal UserSession userSession //로그인된 사용자 정보
    ){
        log.info("login user {}", userSession); //누가 연결했는지 로그 출력

        //1. SseEmitter 생성 → 서버와 클라이언트가 실시간으로 연결된 객체
        //클라이언트와의 SSE 연결 객체 생성
        //SseEmitter는 서버가 클라이언트에 지속적으로 데이터를 푸시할 수 있도록 해주는 클래스
        var emitter = new SseEmitter(1000L * 60); //기본 30초 단위로 재연결 시도함 -> 나는 60초동안 연결이 없으면 재연결시킬거다

        //2. 로그인한 유저의 userId를 key로 하여 emitter 저장
        userConnection.put(userSession.getUserId().toString(), emitter);

        /**
         * 3. 클라이언트와 연결이 일정 시간 동안 유지되지 않으면 타임아웃 발생
         * 타임아웃 시 연결을 종료 (complete)
         */
        emitter.onTimeout(() -> {
            log.info("on timeout");
            //클라이언트와 타임아웃이 일어났을 때
            emitter.complete(); // 연결 종료
        });

        /**
         * 4. 클라이언트와의 SSE 연결이 정상적으로 종료됐을 때 실행되는 콜백
         */
        emitter.onCompletion(() ->{
            log.info("on completion");
            //클라이언트와 연결이 종료됐을 때 하는 작업
            userConnection.remove(userSession.getUserId().toString()); // 연결 종료 시 해당 사용자 emitter 제거
        });

        /** 5. 클라이언트에 최초 연결이 성공했다는 메시지 전송 (클라이언트에서 "onopen" 이벤트 수신)
         * 최초 연결 직후, 클라이언트에 최초 이벤트를 한 번 보내서 연결이 정상적으로 되었는지 확인
         * 클라이언트에서는 "onopen" 이벤트가 수신되었는지를 확인함
         */
        var event = SseEmitter
                .event()                       // SSE 이벤트 생성
                .name("onopen");     // 이벤트 이름 지정


        try {
            // 이벤트를 클라이언트에게 전송
            emitter.send(event);
        } catch (IOException e) {
            emitter.completeWithError(e); // 전송 실패 시 오류로 연결 종료
        }

        // 6. 클라이언트에 emitter 객체를 반환 → 클라이언트는 이제 연결된 상태에서 서버의 푸시를 기다림
        return emitter;
    }

    /**
     * 서버가 특정 사용자에게 메시지를 보내는 기능
     * - 실제 서비스에서는 주문 발생, 결제 완료 등 이벤트 발생 시 호출됨
     */
    @GetMapping("/push-event")
    public void pushEvent(
            @Parameter(hidden = true)
            @AuthenticationPrincipal UserSession userSession
    ){
        //기존에 연결된 유저 찾기
        //1. 해당 사용자의 연결된 emitter 꺼내기
        var emitter = userConnection.get(userSession.getUserId().toString());

        //2. 전송할 메시지 생성
        var event = SseEmitter
                .event()
                .data("hello"); // 클라이언트에 보낼 실제 데이터

        try{
            //3. 클라이언트에 메시지 전송
            emitter.send(event);
        }catch (IOException e){
            emitter.completeWithError(e); // 전송 실패 시 연결 종료
        }
    }
}
