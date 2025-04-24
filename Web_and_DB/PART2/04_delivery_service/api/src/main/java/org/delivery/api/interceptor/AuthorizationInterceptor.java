package org.delivery.api.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    //사전에 검증
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //interceptor로 어떠한 url을 처리하는지 로그
        log.info("Authorization Interceptor url : {}", request.getRequestURI());

        //WEB, chrome의 경우) GET, POST 등 API를 처리하기 전에 OPTIONS이라는 API 요청을 해서 해당 메소드를 지원하는지 체크하는 API가 있다. 이거를 통과(pass)시켜줄거다
        if(HttpMethod.OPTIONS.matches(request.getMethod())){
            return true;
        }

        //resource 검증: js, html, png resource를 요청하는 경우 통과(pass)
        if(handler instanceof ResourceHttpRequestHandler){
            return true;
        }

        // TODO header 검증


        return true; // 일단 통과처리

    }
}
