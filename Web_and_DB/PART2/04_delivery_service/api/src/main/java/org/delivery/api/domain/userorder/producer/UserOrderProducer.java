package org.delivery.api.domain.userorder.producer;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.rabbitmq.Producer;
import org.delivery.common.message.model.UserOrderMessage;
import org.delivery.db.userorder.UserOrderEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
/** UserOrderEntity 주문 정보를 RabbitMQ 메시지로 변환해 Exchange로 보내는 역할
 * - 사용자가 주문할 때마다 메시지를 만들어서 전달하는 역할
 * - 메시지를 만들고 Exchange로 보내는 책임
 *
 * [전체 흐름]
 * [ User → 주문 요청 → API 서버 ]
 *            ↓
 * [ UserOrderEntity 생성됨 ]
 *            ↓
 * [ UserOrderProducer.sendOrder() 호출 ]
 *            ↓
 * [ UserOrderMessage 생성 (공통 메시지 DTO) ]
 *            ↓
 * [ RabbitTemplate → Exchange → Queue ]
 *            ↓
 * [ Consumer가 이 메시지(UserOrderMessage)를 받음 ]
 */
public class UserOrderProducer {

    // 실제 메시지를 전송할 때 사용하는 공통 Producer (RabbitTemplate을 내부에 갖고 있음)
    private final Producer producer;

    // 메시지를 보낼 Exchange 이름과 Routing Key (이름은 RabbitMqConfig에서 정의된 값과 일치해야 함)
    private static final String EXCHANGE = "delivery.exchange";
    private static final String ROUTE_KEY = "delivery.key";

    /** [주문 보내기]
     * 주문 메시지를 보낼 때 사용하는 메서드 (주문 객체를 인자로 받음)
     * - 주문이 생성된 후 이 메서드를 호출하면 메시지가 Queue로 전달됨
     */
    public void sendOrder(UserOrderEntity userOrderEntity){ // 사용자 주문에 해당하는 UserOrderEntity
        sendOrder(userOrderEntity.getId());
    }

    /** 오버로딩 : 사용자가 언제든지 주문을 하게 되면 UserOrderEntity 또는 userOrderId를 넣어서 message를 만든 후, Queue에다가 집어넣는 과정이다.
     * 주문 ID를 기반으로 메시지를 만들어서 RabbitMQ로 전송하는 메서드
     * - 메시지를 직접 만들고, 공통 producer를 통해 메시지를 보냄
     * - 메시지는 공통 모듈에 정의된 UserOrderMessage 객체
     */
    public void sendOrder(Long userOrderId){ //위에서 보낸 userOrderId를 받아서 message 보낸다
        var message = UserOrderMessage.builder()
                .userOrderId(userOrderId)
                .build();

        producer.producer(EXCHANGE, ROUTE_KEY, message);
    }
}

