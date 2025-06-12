package org.delivery.api.config.health;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.api.common.rabbitmq.Producer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/open-api")
@RequiredArgsConstructor
public class HealthOpenApiController {

//    private final Producer producer; // 더이상 동작하지 않도록 주석처리.

    @GetMapping("/health")
    public void health(){
        log.info("### health call ###");

        //rabbitmq 테스트
        producer.producer("delivery.exchange", "delivery.key", "hello");
    }
}
