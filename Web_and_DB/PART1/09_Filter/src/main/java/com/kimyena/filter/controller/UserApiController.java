package com.kimyena.filter.controller;

import com.kimyena.filter.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("/register") //http://localhost:8080/api/user/register
    public void register(
            @RequestBody
            UserRequest userRequest
    ){
        log.info("{}", userRequest);
    }
}
