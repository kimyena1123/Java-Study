package com.kimyena.http_cookie.controller;

import com.kimyena.http_cookie.db.UserRepository;
import com.kimyena.http_cookie.model.UserDto;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {
    //사용자의 정보를 요청했을 때, 해당 유저를 어떻게 식별할 수 있는가

    private final UserRepository _userRepository;
    private final UserRepository userRepository;

    /**
     * 방법1. 쿠키를 찾아내는 방법
     */
    @GetMapping("/me")
    public UserDto me(
            HttpServletRequest httpServletRequest
    ){
        //쿠키 받기. 어떤 쿠키가 있는지 확인
        var cookies = httpServletRequest.getCookies();

        if(cookies != null){
            for(Cookie cookie : cookies){
                log.info("key: {}, value : {}", cookie.getName(), cookie.getValue()); //key: authorization-cookie, value : caad7f26-0440-4521-99aa-644213cc966d
            }
        }

        return null;
    }

    /**
     * 방법2. 쿠키를 직접 받는 방법
     */
    @GetMapping("/me2")
    public UserDto me2(
            @CookieValue(name = "authorization-cookie", required = false)
            String authorizationCookie
    ){

        log.info("authorizationCookie: {} ", authorizationCookie);  //authorizationCookie: c52a48f0-f037-4522-9722-746941c95210

        var optionalUserDto = userRepository.findById(authorizationCookie);
        System.out.println("optionalUserDto로 유저 정보 가져오기: " + optionalUserDto); //Optional[UserDto(id=6e4026b2-2b74-4d1c-b16c-80953864503a, name=홍길동, password=1234)]

        return optionalUserDto.get();
    }

    /**
     * HTTP Header 인증
     */
    @GetMapping("/me3")
    public UserDto me3(
            @RequestHeader(name = "authorization", required = false)
            String authorizationHeader
    ){

        log.info("authorizationHeader: {} ", authorizationHeader);  //authorizationCookie: c52a48f0-f037-4522-9722-746941c95210

        var optionalUserDto = userRepository.findById(authorizationHeader);
        System.out.println("유저 정보 가져오기: " + optionalUserDto);

        return optionalUserDto.get();
    }
}

