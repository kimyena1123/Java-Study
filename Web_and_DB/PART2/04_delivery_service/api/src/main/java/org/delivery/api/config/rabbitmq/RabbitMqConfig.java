package org.delivery.api.config.rabbitmq;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Spring Boot가 실행될 때, 여기에 있는 값을 config로 참조할 수 있도록 달아둔다
/* producer가 exchange에 데이터를 넣어야 한다. 그래서 rabbitMq management 관리자 페이지에서 만들 수도 있고 또는 코드랩에서도 만들 수 있다.

    producer(생산자)가 Exchange에 메시지를 넣기 위해서는, Exchange가 먼저 존재해야 하고, 그 Exchange와 연결된 Queue도 있어야 메시지가 올바르게 흘러갈 수 있다. 이 작업은 두가지 방법으로 할 수 있다.
    1. RabbitMQ 관리자 페이지(Management UI)에서 직접 만들기
    2. Java(Spring Boot) 코드로 설정(코드랩 방식)

    [흐름]
    Producer (Spring 앱)
     |
     | (RabbitTemplate 사용)
     V
    [ Exchange (delivery.exchange) ]
     |
     | (routing key: delivery.key)
     V
    [ Queue (delivery.queue) ]

 */
public class RabbitMqConfig  {

    // ============================== [1] Exchange 설정 ==============================
    /**
     * DirectExchange 생성
     * - 메시지의 routing key와 정확히 일치하는 queue에 메시지를 전달하는 방식
     *      - 메시지를 전송할 때 사용되는 "routing key"값과
     *      - queue와 연결될 때 설정한 "binding key"가 정확히 일치해야 queue로 메시지를 전달.
     * - 여기서는 "delivery.exchange"라는 이름의 exchange를 생성
     */
    @Bean
    public DirectExchange directExchange(){

        return new DirectExchange("delivery.exchange");
    }

    // ============================== [2] Queue 설정 ==============================
    /**
     * Queue 생성
     * - 메시지를 저장하는 버퍼 역할(임시 저장하는 공간)
     * - Consumer가 바로 받지 않더라도 메시지를 저장해두고 나중에 가져갈 수 있음
     *      - Producer가 메시지를 보낸다고 해서 바로 Consumer가 받는게 아니다.
     *      - 메시지는 먼저 Queue에 들어가고, Consumer는 Queue에서 메시지를 가져간다.
     * - 여기서는 "delivery.queue"라는 이름의 queue를 생성
     */
    @Bean
    public Queue queue(){

        return new Queue("delivery.queue");
    }

    // ============================== [3] Binding 설정 ==============================
    /**
     * Exchange와 Queue를 연결(Binding)
     * - 메시지가 들어올 때 어떤 키로 어떤 큐에 보낼 지 연결
     * - routing key: "delivery.key"
     * - 이 키와 정확히 일치하는 메시지만 delivery.queue로 전달됨
     * - Binding을 설정할 때, "routing.key"를 지정해줘야 하고, 이 키가 Producer가 메시지를 보낼 때 사용한 key와 정확히 일치해야 한다
     */
    @Bean
    public Binding binding(DirectExchange directExchange, Queue queue){

        return BindingBuilder
                .bind(queue)                            //queue를
                .to(directExchange)                     //특정 Exchange와 연결하고
                .with("delivery.key");        //routing key를 통해 연결한다
    }


    // ============================== [4] RabbitTemplate 설정 ==============================
    /**
     * RabbitTemplate : RabbitMQ에 메시지를 전송하거나 수신할 때 사용하는 도구. 메시징을 쉽게 해줌.
     * - Java 객체를 RabbitMQ로 보내기 위한 도구
     * - 메시지 전송 시 사용할 메시지 변환기 설정 포함
     * - 기본적으로 문자열, byte[] 형식으로 메시지를 주고받지만, 우리가 사용하는 Java 객체를 JSON 형태로 자동 변환하려면 MessageConverter가 필요함
     *
     * - RabbitTemplate : Producer에서 Exchange로 메시지를 보내기 위해 사용
     * - why? Producer가 직접 Queue에 매시지를 넣는게 X. Exchange에 메시지를 보내고 > Exchange는 routing key를 기준으로 메시지를 Queue에 전달
     *      - 즉, Producer는 "Exchange에 메시지를 보내는 역할"만 하면 됨. << 이 역할을 도와주는 게 RabbitTemplate임
     * - 왜 필요한가?
     *      - RabbitMQ 서버와 완결, JSON 형식으로 직렬화 처리, 설정 주입, 예외 처리 등 재시도 설정 << 이걸 직접 구현하면 복잡하고 코드 길어짐
     *      - 이 모든 걸 대신 해주는 RabbitTemplate을 Spring이 제공.
     */
    @Bean
    public RabbitTemplate rabbitTemplate(
            ConnectionFactory connectionFactory,
            MessageConverter messageConverter
    ){
        var rabbitTemplate = new RabbitTemplate(connectionFactory);

        // 메시지를 보낼 때 사용할 변환기를 설정
        // Java 객체 -> JSON, JSON -> Java 객체 자동 변환
        rabbitTemplate.setMessageConverter(messageConverter); //Object <-> JSON 변환기 설정

        return rabbitTemplate;
    }

    // ============================== [5] 메시지 변환기 설정 ==============================
    /**
     * 메시지 변환기 설정(Jackson)
     * - RabbitTemplate이 Java 객체를 JSON 문자열로 변환하거나, 그 반대로 할 수 있도록 돕는다.
     * - Java 객체를 JSON 문자열로 직렬화하거나, JSON을 Java 객체로 역직렬화
     *      - 메시지를 보내기 전 → Java 객체 → JSON 등으로 직렬화
     *      - 메시지를 받을 때 → JSON → Java 객체로 역직렬화
     * - ObjectMapper는 우리가 ObjectMapperConfig에서 설정한 값이 자동 주입된다.(api/src/main/java/org.delivery.api/config/ObjectMapperConfig)
     */
    @Bean
    public MessageConverter messageConverter(ObjectMapper objectMapper) { //bean으로 등록되어 있는 object mapper(ObjectMapperConfig 클래스에서)가 이쪽으로 온다
        return new Jackson2JsonMessageConverter(objectMapper);
    }

    // Producer(RabbitTemplate)에서 Exchange로 보내주는 메소드는 common/rabbitmq 패키지에 위치해 있다.
    // 왜?
    //  - RabbitMqConfig는 "설정"만 담당(Exchange, Queue, Binding, RabbitTemplate 생성, 객체 생성 및 Bean 등록만 함)
    //  - Producer는 "실제 메시지 전송 기능(사용)"을 담당(실제로 메시지를 전송하는 메서드 가지고 있음)


}
