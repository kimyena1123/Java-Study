package com.kimyena.http_cookie.controller;

import com.kimyena.http_cookie.model.LoginRequest;
import com.kimyena.http_cookie.service.UserService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.swing.*;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApiController {

    private final UserService userService;

    //cookie 인증
    @PostMapping("/login")
    public void login(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ){
        userService.login(loginRequest, httpServletResponse);
    }


    //http header 인증
    @PostMapping("/login2")
    public String login2(
            @RequestBody
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ){
        return userService.login2(loginRequest, httpServletResponse);
    }
}
