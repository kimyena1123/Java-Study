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

@Slf4j
@RestController
@RequestMapping("/api/sse")
@RequiredArgsConstructor
public class SseApiController {
    /**
     * 클라이언트가 SSE 연결을 맺기 위해 호출하는 엔드포인트
     * - produces = MediaType.TEXT_EVENT_STREAM_VALUE : SSE 스트림 형식으로 응답
     * - 로그인된 사용자의 정보를 AuthenticationPrincipal로 주입
     */
    @GetMapping(path = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseBodyEmitter connect(
            @Parameter(hidden = true) //swagger문서에는 이 파라미터 숨김
            @AuthenticationPrincipal UserSession userSession //로그인된 사용자 정보
    ){
        log.info("login user {}", userSession); //누가 연결했는지 로그 출력

        //클라이언트와의 SSE 연결 객체 생성
        //SseEmitter는 서버가 클라이언트에 지속적으로 데이터를 푸시할 수 있도록 해주는 클래스
        var emitter = new SseEmitter();

        /**
         * 클라이언트와 연결이 일정 시간 동안 유지되지 않으면 타임아웃 발생
         * 타임아웃 시 연결을 종료 (complete)
         */
        emitter.onTimeout(() -> {
            //클라이언트와 타임아웃이 일어났을 때
            emitter.complete(); // 연결 종료
        });

        /**
         * 클라이언트와의 SSE 연결이 정상적으로 종료됐을 때 실행되는 콜백
         */
        emitter.onCompletion(() ->{
            //클라이언트와 연결이 종료됐을 때 하는 작업

        });

        /**최초 연결시 응답 전송
         * 최초 연결 직후, 클라이언트에 최초 이벤트를 한 번 보내서 연결이 정상적으로 되었는지 확인
         * 클라이언트에서는 "onopen" 이벤트가 수신되었는지를 확인함
         */
        var event = SseEmitter
                .event()                       // SSE 이벤트 생성
                .name("onopen")     // 이벤트 이름 지정
                .data("connect");      // 전달할 데이터


        try {
            // 이벤트를 클라이언트에게 전송
            emitter.send(event);
        } catch (IOException e) {
            emitter.completeWithError(e); // 전송 실패 시 오류로 연결 종료
        }

        // 클라이언트에 emitter 객체를 반환 → 클라이언트는 이제 연결된 상태에서 서버의 푸시를 기다림
        return emitter;
    }
}
