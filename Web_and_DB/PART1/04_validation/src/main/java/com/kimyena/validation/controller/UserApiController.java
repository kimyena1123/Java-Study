package com.kimyena.validation.controller;

import com.kimyena.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public UserRegisterRequest register(
            @Valid  //요청이 들어올 때, 자동으로 해당 클래스에 대해서 붙어있는 어노테이션 기반으로 검증해준다.
            @RequestBody
            UserRegisterRequest userRegisterRequest){
        log.info("init : {}", userRegisterRequest);

        return userRegisterRequest;
    }
}
