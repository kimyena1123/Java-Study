package org.delivery.storeadmin.config.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {

    // ============================== 메시지 변환기 설정 ==============================
    /**
     * 메시지 변환기 설정(Jackson)
     * - RabbitTemplate이 Java 객체를 JSON 문자열로 변환하거나, 그 반대로 할 수 있도록 돕는다.
     * - Java 객체를 JSON 문자열로 직렬화하거나, JSON을 Java 객체로 역직렬화
     *      - 메시지를 보내기 전 → Java 객체 → JSON 등으로 직렬화
     *      - 메시지를 받을 때 → JSON → Java 객체로 역직렬화
     * - ObjectMapper는 우리가 ObjectMapperConfig에서 설정한 값이 자동 주입된다.(api/src/main/java/org.delivery.api/config/ObjectMapperConfig)
     */
    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) {

        return new Jackson2JsonMessageConverter(objectMapper);
    }
}
