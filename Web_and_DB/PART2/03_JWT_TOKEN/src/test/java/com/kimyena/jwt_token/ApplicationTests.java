package com.kimyena.jwt_token;

import com.kimyena.jwt_token.service.JwtService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.HashMap;

@SpringBootTest
class ApplicationTests {


    private final JwtService jwtService;

    @Autowired
    ApplicationTests(JwtService jwtService) {
        this.jwtService = jwtService;
    }


    @Test
    void contextLoads() {
    }

    @Test
    void tokenCreate(){
        var claims = new HashMap<String, Object>();
        claims.put("user_id", 923);

        var expireAt = LocalDateTime.now().plusSeconds(10); //10초동안만 유효함

        var jwtToken = jwtService.craeteToken(claims, expireAt);
        System.out.println("jwtToken: " + jwtToken); //eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTc0NDk1NjE3MX0.zWYxijQAzOA5DLX1oouEHSj-XwUPXDeuvO1YFpn_owk
    }

    @Test
    void tokenValidation(){
        var token = "eyJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjo5MjMsImV4cCI6MTc0NDk1NTgyOH0.VEvGaDryz7NWvh0Qte6_3TYZPwpdblOiniIn7B1wAmk";

        jwtService.validatetionToken(token);
    }

}
