package org.delivery.storeadmin.domain.sse.connection.ifs;

/**
 * 여러 종류의 연결(SSE, WebSocket 등)을 관리할 수 있게 하기 위해 공통 인터페이스로 추상화함
 * SseConnectionPool이 이 인터페이스를 구현하여 사용자 연결 추가, 조회, 제거 작업을 할 수 있게 만든다.
 * @param <T>
 * @param <R>
 */
public interface ConnectionPoolInterface<T, R> {

    //[둥록] 사용자 고유키(uniqueKey)를 기반으로 연결 객체(session)을 등록
    void addSession(T uniqueKey, R session); //usersession에 대한 객체가 필요

    //[조회] addSession()으로 저장된 emitter를 가져옴
    R getSession(T uniqueKey);

    //연결이 끊기거나(completion) timeout 됐을 때 처리할 콜백
    void onCompletionCallback(R session);
}
