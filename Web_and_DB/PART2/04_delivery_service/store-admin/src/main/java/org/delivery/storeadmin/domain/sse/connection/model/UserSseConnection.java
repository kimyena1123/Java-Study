package org.delivery.storeadmin.domain.sse.connection.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.ToString;
import org.delivery.storeadmin.domain.sse.connection.ifs.ConnectionPoolInterface;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;

@Getter
@ToString
@EqualsAndHashCode
/**
 * [사용자 단일 SSE 연결 객체] : 이 클래스는 한명의 사장님(사용자)과 서버 간의 SSE 연결을 관리한다
 *
 * 왜 필요한가?
 * - 사장님마다 교유한 SseEmitter가 필요하다 (서버 -> 사장님 브라우저로 알림 전송용)
 * - 이 클래스를 통해 emitter와 관련된 공통 기능(등록, 메시지 전송, 콜백 처리 등)을 쉽게 구현할 수 있다
 * - emitter에 대한 생성, 이벤트 전송, 콜백 처리를 캡슐화 한다.
 */
public class UserSseConnection {

    private final String uniqueKey; //각 유저의 SSE 연결을 구분하기 위한 고유 키(각 사장님을 구분하기 위한 고유키)
    private final SseEmitter sseEmitter;  //Spring에서 제공하는 SSE 연결 객체

    //연결 종료 시 콜백을 위해 ConnectionPool의 인터페이스를 참조
    private final ConnectionPoolInterface<String, UserSseConnection> connectionPoolInterface;

    //메시지(JSON 변환)을 위해 사용하는 JackSon의 ObjectMapper
    private final ObjectMapper objectMapper;


    /**
     * [생성자 - private]
     *
     * UserSseConnection 객체는 직접 생성하지 않고 static 메서드(connect)로 생성한다.
     * 이 안에서 emitter를 생성하고, 콜백 등록, 연결 확인 메시지 전소을 모두 처리한다.
     *
     * 사용자마다 만들어지는 객체이다. 여기에서 SseConnectionPool로 호출이 가능해야 하는데 어떻게? => 콜백 메소드를 사용해서
     */
    private UserSseConnection(
            String uniqueKey,
            ConnectionPoolInterface<String, UserSseConnection> connectionPoolInterface,
            ObjectMapper objectMapper
    ){

        //1. key 초기화(고유 키 저장)
        this.uniqueKey = uniqueKey;

        //2. sse 초기화(SSE 연결 객체 생성)
        this.sseEmitter = new SseEmitter(1000L * 60); //60초동안 연결 유지

        //3. 콜백 메서드와 연결 풀 저장
        this.connectionPoolInterface = connectionPoolInterface;

        //4. object mapper 초기화(JSON 직렬화를 위한 objectMapper 저장)
        this.objectMapper = objectMapper;

        /**
         * 5. 콜백 등록
         * - 연결이 끊기거나(timeout) 정상 종료될 경우 호출될 로직을 등록한다.
         * SSE가 초기화되면 반드시 해줘야 하는 작업 -> onCompletion, onTimeout, onopne
         * - 왜? 필수는 아니지만
         *  - onCompletion: 클라이언트가 연결종료했을 때, 서버 리소스를 안전하게 정리하려고
         *  - onTimeout: 클라이언트가 응답없이 오래 대기하면 서버에서 정리하기 위해
         *  - onopen 메시지 전송: 서버연결이 정상적으로 완료됐는지 클라이언트가 알 수 있도록 하기 위해(진짜 연결됐는지 확인하기 위해)
         */

        //5-1. 연결 종료 시 처리 (브라우저 탭을 닫는 등)
        this.sseEmitter.onCompletion(() ->{
            //연결이 종료되면 connection pool에서 remove를 시켜줘야 한다
            this.connectionPoolInterface.onCompletionCallback(this);
        });

        //5-2. 타임아웃 시 처리
        this.sseEmitter.onTimeout(() -> {
            this.sseEmitter.complete(); // 타임아웃 시 연결 종료 처리
        });

        //6. 연결이 성공했음을 브라우저 측에 알림(초기 핑)
        sendMessage("onopen", "connect");
    }

    /**
     * [정적 팩토리 메서드]
     * - 외부에서는 이 메서드를 통해 객체를 생성한다
     * - 생성자 내부에서 콜백 등록 및 초기 메세지 전송을 포함하므로 이 메서드를 통해 객체를 만드는 게 안전하다
     */
    public static UserSseConnection connect(
            String uniqueKey,
            ConnectionPoolInterface<String, UserSseConnection> connectionPoolInterface,
            ObjectMapper objectMapper
    ){
        return new UserSseConnection(uniqueKey, connectionPoolInterface, objectMapper);
    }

    /**
     * [서버 -> 클라이언트로 메시지를 전송하는 메서드(이벤트 이름 포함)]
     *
     * 서버에서 클라이언트로 메시지를 조금 더 편하게 보내기 위한 메소드
     * - eventName: 클라이언트에서 수신할 이벤트 이름
     * - data: 보낼 실제 메시지 내용
     */
    public void sendMessage(String eventName, Object data){ // Object를 JSON으로 넘겨줘야 할거임

        try {
            //data 객체를 JSON 문자열로 직렬화
            var json = this.objectMapper.writeValueAsString(data);

            //SSE 이벤트 구성(이벤트 이름 + 데이터)
            var event = SseEmitter.event()
                    .name(eventName)
                    .data(json);

            //메시지 전송
            this.sseEmitter.send(event);

        } catch (IOException e) {
            this.sseEmitter.completeWithError(e); //전송 실패시 연결 종료 처리
        }
    }

    /**
     * [서버 -> 클라이언트로 메시지를 전송하는 메서드(이벤트 이름 없이)]
     *
     * - 클라이언트에서 'onmessage'로 받는 기본 이벤트를 사용하는 경우
     * - event 이름이 생략된 경우
     */
    public void sendMessage(Object data){ //event 이름 없이 onmessage로 보내는 경우도 있을 수 있다

        try {
            // data 객체를 JSON 문자열로 직렬화
            var json = this.objectMapper.writeValueAsString(data);

            // 이벤트 이름 없이 데이터만 전송
            var event = SseEmitter.event()
                    .data(json);

            this.sseEmitter.send(event);

        } catch (IOException e) {
            this.sseEmitter.completeWithError(e);
        }
    }
}
