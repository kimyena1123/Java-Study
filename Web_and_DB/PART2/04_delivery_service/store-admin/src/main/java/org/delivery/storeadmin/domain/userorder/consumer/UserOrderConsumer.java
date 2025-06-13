package org.delivery.storeadmin.domain.userorder.consumer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.common.message.model.UserOrderMessage;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component //@Service라고 해도 된다
@RequiredArgsConstructor
public class UserOrderConsumer {

    @RabbitListener(queues = "delivery.queue") //어떤 queue로부터 받아올건지 queue 이름을 적어주면 된다
    public void userOrderConsumer(
            //객체로 받아도 되고, String으로 받아도 된다
            UserOrderMessage userOrderMessage

    ){
        log.info("message queue >> {}", userOrderMessage);
    }
}
