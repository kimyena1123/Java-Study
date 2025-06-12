package org.delivery.api.common.rabbitmq;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

/**
 * @Comopnenet - 사용위치: 클래스 위에 사용, 대상: 클래스 전체(Spring이 적접 스캔), 용도: 서비스, 유틸, 기능 클래스 등록 등
 * @Bean - 사용위치: 메서드 위에 사용, 대상: 객체(Bean)을 리턴하는 메서드, 용도: 설정 파일 내에서 객체를 수동 등록할 때
 */
@Component // 이 클래스를 스프링 빈으로 자동 등록시켜줌 (컴포넌트 스캔 대상이 됨)
@RequiredArgsConstructor

public class Producer {
    /**
     * 실제 RabbitMQ에 메시지를 전송하는 클래스 (Producer 역할)
     * - 이 클래스는 설정이 아니라, "기능"을 담당한다.
     * - 서비스 계층 등에서 이 클래스를 사용해서 메시지를 보낼 수 있다.
     */

    // 메시지를 RabbitMQ로 전송할 때 사용하는 템플릿 객체
    // - RabbitMqConfig에서 설정한 RabbitTemplate이 주입된다.
    private final RabbitTemplate rabbitTemplate;

    /**
     * 메시지 전송 메서드
     *
     * @param exchange 메시지를 보낼 Exchange 이름
     * @param routeKey 라우팅 키 (Exchange → Queue로 라우팅할 때 사용)
     * @param object 보낼 Java 객체 (자동으로 JSON으로 변환됨)
     *
     * 이 메서드는 다음과 같은 일을 한다:
     * 1. Java 객체를 JSON으로 직렬화 (RabbitTemplate 내부에서 Jackson 변환기 사용)
     * 2. 지정된 Exchange에 메시지를 보냄
     * 3. routing key를 통해 올바른 Queue에 메시지가 도착하게 됨
     */
    public void producer(String exchange, String routeKey, Object object){
        rabbitTemplate.convertAndSend(exchange, routeKey, object);
    }
}
