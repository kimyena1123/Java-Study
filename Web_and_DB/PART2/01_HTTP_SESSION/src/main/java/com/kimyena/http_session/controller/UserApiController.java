package com.kimyena.http_session.controller;

import com.kimyena.http_session.model.UserDto;
import jakarta.servlet.http.HttpSession;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    //본인의 정보를 반환하는 데이터
    @GetMapping("/me") //http://localhost:8080/api/user/me
    public UserDto me(
            HttpSession httpSession
    ){
        var userObject = httpSession.getAttribute(("USER"));

        if(userObject != null) {
            var userDto = (UserDto) userObject;

            return userDto;
        }else{
            return null;
        }

    }
}
