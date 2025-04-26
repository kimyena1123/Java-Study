package org.delivery.api.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.TokenErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.token.business.TokenBusiness;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import java.util.Objects;

@Slf4j
@RequiredArgsConstructor
@Component
public class AuthorizationInterceptor implements HandlerInterceptor {

    private final TokenBusiness tokenBusiness;

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

        // header 검증
        var accessToken = request.getHeader("authorization-token");
        if(accessToken == null){
            throw new ApiException(TokenErrorCode.AUTHORIAZATION_TOKEN_NOT_FOUND);
        }

        var userId = tokenBusiness.validationAccessToken(accessToken);

        if(userId != null){

            var requestContext = Objects.requireNonNull(RequestContextHolder.getRequestAttributes());
            //사용자 인증이 되면 setAttribute를 이용해서 값을 넣는다.
            requestContext.setAttribute("userId", userId, RequestAttributes.SCOPE_REQUEST);

            return true;
        }

        throw new ApiException(ErrorCode.BAD_REQUEST, "인증 실패");

    }
}
