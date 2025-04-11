package com.kimyena.filter.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Component
public class OpenApiInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("pre handle");
        //true가 되면 controller로 전달하고, false가 되면 controller로 전달하지 않는다.

        /*모든 주소를 다 검증할건데, 다만 그 handler 특정 어노테이션을 가지고 있을 떄만 통과시켜주도록 할 거다. */

        //hander 형변환
        var handlerMethod = (HandlerMethod) handler;

        //해당 controller나 method에 커스텀한 어노테이션(OpenApi)를 가지고 있는지 확인
        var methodLevel = handlerMethod.getMethodAnnotation(OpenApi.class); //메소드에 @OpenAi 가 있는지 확인
        var classLevel = handlerMethod.getBeanType().getAnnotation(OpenApi.class); //클래스에 @OpenAi 가 있는지 확인

        if(methodLevel != null) { //@OpenAi가 있으면 true
            log.info("method level");
            return true;
        }

        if(classLevel != null) {
            log.info("class level");
            return true;
        }

        log.info("open Api 아닙니다 : {}", request.getRequestURI());
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("post handle");
//        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception { //완료됐을 때 호출된다.
        //위 매개면수에 있는 exception은 controller에서 터지는 exception이다.
        log.info("after completion");
//        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }




}
