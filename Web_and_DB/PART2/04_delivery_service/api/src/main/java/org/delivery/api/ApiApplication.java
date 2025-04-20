package org.delivery.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
//@SpringBootApplication(scanBasePackages = {"org.delivery.api", "org.delivery.db"})
//@EnableJpaRepositories(basePackages = "org.delivery.db") // ✅ 추가
//@EntityScan(basePackages = "org.delivery.db")
public class ApiApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApiApplication.class, args);
    }
}
