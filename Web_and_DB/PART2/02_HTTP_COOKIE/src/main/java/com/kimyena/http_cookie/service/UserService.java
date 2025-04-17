package com.kimyena.http_cookie.service;

import com.kimyena.http_cookie.db.UserRepository;
import com.kimyena.http_cookie.model.LoginRequest;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();
        var optionalUser = userRepository.findByName(id);

        if(optionalUser.isPresent()){
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)){
                //cookie 해당 정보를 저장
                var cookie = new Cookie("authorization-cookie", userDto.getId());

                //cookie에는 domain을 지정해야 한다. cookie는 특정 도메인에서만 활용할 수 있게 되어 있기 때문에
                cookie.setDomain("localhost"); //naver.com, daum.net, dev.xxx.com <<xxx.com
                cookie.setPath("/");
                cookie.setMaxAge(-1); //-1이면 연결된 동안에만 사용하겠다. 여기에다가 시간을 지정할 수 있다.

                //cookie 추가
                httpServletResponse.addCookie(cookie);

            }else{
                throw new RuntimeException("Passwords do not match");
            }
        }else{
            throw new RuntimeException("User Not Found");
        }
    }
}
