package org.delivery.storeadmin.domain.sse.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.delivery.storeadmin.domain.sse.connection.SseConnectionPool;
import org.delivery.storeadmin.domain.sse.connection.model.UserSseConnection;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api/sse")
@RequiredArgsConstructor
public class SseApiController {

    private final SseConnectionPool sseConnectionPool; // 실제 연결을 저장 및 관리하는 SSE Connection Pool
    private final ObjectMapper objectMapper; // JSON 직렬화를 위한 ObjectMapper


    /**
     * [클라이언트가 서버와 SSE 연결을 요청하는 API]
     *
     * - 사장님(클라이언트)이 이 API를 호출하면 서버와 실시간 연결을 맺음.
     * - produces = TEXT_EVENT_STREAM : SSE 연결에서 필수 설정 (스트리밍 가능하게)
     * - 로그인된 사장님의 정보를 @AuthenticationPrincipal을 통해 주입받음.
     *
     * 이 연결을 통해 서버는 해당 사장님에게 실시간으로 주문 도착 등의 알림을 보낼 수 있다.
     */
    @GetMapping(path = "/connect", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseBodyEmitter connect(
            @Parameter(hidden = true) //swagger문서에는 이 파라미터 숨김
            @AuthenticationPrincipal UserSession userSession //로그인된 사용자 정보
    ){
        log.info("login user {}", userSession); //누가 연결했는지 로그 출력

        // [1] UserSseConnection 객체 생성 (SseEmitter 포함)
        var userSseConnection = UserSseConnection.connect(
                userSession.getStoreId().toString(),  // storeId를 uniqueKey로 사용
                sseConnectionPool,                    // 콜백 처리를 위한 pool 전달
                objectMapper                          // 메시지 JSON 직렬화를 위해 전달
        );

        // [2] connection pool에 사장 연결 정보 등록
        sseConnectionPool.addSession(userSseConnection.getUniqueKey(), userSseConnection); // storeId와 연결 객체

        // [3] SseEmitter 반환 → 클라이언트와 연결됨
        return userSseConnection.getSseEmitter();
    }


    /**
     * [특정 사장님에게 메시지를 푸시하는 테스트용 API] :  서버가 특정 사용자에게 메시지를 보내는 기능
     *
     * - 실제 서비스에서는 새로운 주문 발생, 결제 완료 등 이벤트가 발생할 때 서버 내부에서 호출됨.
     * - 이 예시에서는 단순히 "hello world"라는 메시지를 push.
     * - 연결이 존재할 경우에만 메시지를 보냄 (null safe).
     */
    @GetMapping("/push-event")
    public void pushEvent(
            @Parameter(hidden = true)
            @AuthenticationPrincipal UserSession userSession
    ){
        // [1] 해당 사장님의 연결 객체를 pool에서 조회
        var userSseConnection = sseConnectionPool.getSession(userSession.getStoreId().toString());

        // [2] 연결이 존재한다면 메시지 전송
        Optional.ofNullable(userSseConnection)
                .ifPresent(it -> {
                    it.sendMessage("hello world");
                });
    }
}
