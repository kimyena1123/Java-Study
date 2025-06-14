package org.delivery.storeadmin.domain.sse.connection;

import lombok.extern.slf4j.Slf4j;
import org.delivery.storeadmin.domain.sse.connection.ifs.ConnectionPoolInterface;
import org.delivery.storeadmin.domain.sse.connection.model.UserSseConnection;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
@Component
/**
 * 사용자 SSE 연결을 저장하고 관리하는 실제 구현체
 *
 * 왜 만드는가?
 * - 사용자 별로 SSE 연결(UserSseConnection)을 관리하기 위해
 * - concurrentHashMap으로 thread-safe하게 연결을 저장함
 * - 연결이 끊어지거나 타임아웃되면 해당 연결을 안전하게 제거해주는 로직을 가짐
 */
public class SseConnectionPool implements ConnectionPoolInterface<String, UserSseConnection> { //Bean으로 관리돼서 하나만 존재하는 static 객체이다.

    //사용자의 connection을 저장하는 pool 만들기
    private static final Map<String, UserSseConnection> connectionPool = new ConcurrentHashMap<>();


    //[저장(등록)] 사용자의 SSE 연결을 pool에 저장
    @Override
    public void addSession(String uniqueKey, UserSseConnection userSseConnection) {
        connectionPool.put(uniqueKey, userSseConnection);
        System.out.println("SseConectionPool.java 에서 connectionPool 확인 >> " + connectionPool);
    }

    //저장된 emitter를 가져옴
    @Override
    public UserSseConnection getSession(String uniqueKey) {
        return connectionPool.get(uniqueKey);
    }

    //연결이 끊어졌을 때 콜백 호출됨 -> 연결 제거
    @Override
    public void onCompletionCallback(UserSseConnection session) {
        log.info("call back connection pol completion : {}", session);
        connectionPool.remove(session.getUniqueKey());
    }

}
