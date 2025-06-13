package com.kimyena.rest_api;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimyena.rest_api.model.UserRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ApplicationTests {

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void contextLoads() throws JsonProcessingException {
        // 직렬화를 통해서 JSON 형태로 바꾸기. DTO -> JSON
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUser_age(10);
        user.setUser_email("hone@gmail.com");
        user.setIsKorean(true);

        var json = objectMapper.writeValueAsString(user);
        System.out.println("직렬화(JSON 형태) >> " + json); //{"user_name":"홍길동","user_age":10,"user_email":"hone@gmail.com","is_korean":true}

        //역직렬화: JSON -> DTO
        var dto = objectMapper.readValue(json, UserRequest.class);
        System.out.println("역직렬화(DTO 형태) >> " + dto); //UserRequest(userName=홍길동, user_age=10, user_email=hone@gmail.com, isKorean=true)
    }

}
