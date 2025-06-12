package org.delivery.api.domain.userorder.producer;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.rabbitmq.Producer;
import org.delivery.common.message.model.UserOrderMessage;
import org.delivery.db.userorder.UserOrderEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserOrderProducer {

    private final Producer producer;

    private static final String EXCHANGE = "delivery.exchange";
    private static final String ROUTE_KEY = "delivery.key";

    //주문 보내기
    public void sendOrder(UserOrderEntity userOrderEntity){ // 사용자 주문에 해당하는 UserOrderEntity
        sendOrder(userOrderEntity.getId());
    }

    //오버로딩
    //사용자가 언제든지 주문을 하게 되면 UserOrderEntity 또는 userOrderId를 넣어서 message를 만든 후, Queue에데가 집어넣는 과정이다.
    public void sendOrder(Long userOrderId){ //위에서 보낸 userOrderId를 받아서 message 보낸다
        var message = UserOrderMessage.builder()
                .userOrderId(userOrderId)
                .build();

        producer.producer(EXCHANGE, ROUTE_KEY, message);
    }
}

