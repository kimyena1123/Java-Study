package org.delivery.api.config.web;

import lombok.RequiredArgsConstructor;
import org.delivery.api.interceptor.AuthorizationInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.List;

@Configuration
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final AuthorizationInterceptor authorizationInterceptor; //이게 주입받을 수 있는 이유는 component 때문.

    private List<String> OPEN_API = List.of(
            "/open-api/**"
    );

    //기본적으로 빼줘야할 주소들이 있다.
    private List<String> DEFAULT_EXCLUDE = List.of(
            "/",
            "favicon.ico",
            "/error"
    );

    //swagger도 검증X
    private List<String> SWAGGER = List.of(
            "/swagger-ui.html",
            "/swagger-ui/**",
            "/v3/api-docs/**"
    );


    //interceptor 등록
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        // open-api로 시작하는 애들은 검증하지 않을거다.
        // 대신에 그 외 나머지 모두는 검증할거다.
        registry.addInterceptor(authorizationInterceptor) //아래 3가지 주소 빼고는 다 검증할 거다.
                .excludePathPatterns(OPEN_API)
                .excludePathPatterns(DEFAULT_EXCLUDE)
                .excludePathPatterns(SWAGGER);


    }
}
