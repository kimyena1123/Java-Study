package com.kimyena.filter.controller;

import com.kimyena.filter.interceptor.OpenApi;
import com.kimyena.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpEntity;
import org.springframework.web.bind.annotation.*;

@OpenApi
@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @OpenApi
    @PostMapping("/register") //http://localhost:8080/api/user/register
    public void register(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("original: {}", userRequest); //original: UserRequest(name=null, phoneNumber=010-1111-1111, email=hone@gmail.com, age=10) <- name보면 정보가 다 안왔다.
    }

    @GetMapping("/hello")
    public void hello(){
        log.info("hello");
    }

    @PostMapping("/register1") //http://localhost:8080/api/user/register1
    public void register1( //1, 임시로 디버깅 하는 방법
                           HttpEntity http
    ){
        log.info("method 1: {}", http.getBody()); //method 1: {user_name=홍길동, phone_number=010-1111-1111, email=hone@gmail.com, age=10}
    }
}
