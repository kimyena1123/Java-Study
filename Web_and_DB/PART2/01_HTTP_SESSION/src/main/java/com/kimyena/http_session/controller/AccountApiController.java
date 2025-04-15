package com.kimyena.http_session.controller;

import com.kimyena.http_session.model.LoginRequest;
import com.kimyena.http_session.service.UserService;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApiController {

    private final UserService userService;

    @PostMapping("/login")
    public void login(
            //사용자가 로그인할 때는 아이디와 비밀번호를 보내게 될 거다.
            @RequestBody
            LoginRequest loginRequest,

            //세션을 통한 인증을 해줄거다
            HttpSession httpSession //Spring에서 자동으로 해당 요청에 대한 세션을 하나 만들어서 여기에다 주입해준다.
    ){
        userService.login(loginRequest, httpSession); // loginRequest와 httpSession을 서비스로 넘기면, 실질적인 로직은 Service에서 구현한다!
    }
}
