package org.delivery.storeadmin.domain.user.controller;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.RequiredArgsConstructor;
import org.delivery.storeadmin.domain.authorization.model.UserSession;
import org.delivery.storeadmin.domain.user.controller.model.StoreUserResponse;
import org.delivery.storeadmin.domain.user.converter.StoreUserConverter;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/store-user")
@RequiredArgsConstructor
public class StoreUserApiController {

    private final StoreUserConverter storeUserConverter;

    /* @UserSession과 @AuthenticationPrincipal은 Spring Security에서 로그인한 사용자 정보를 컨트롤러 메서드에 주입할 때 사용하는 방식
        @AuthenticationPrincipal: Spring Security가 제공하는 기본 어노테이션으로, 로그인한 사용자의 정보를 가져오기 위해 사용한다.
        @UserSession: 내가 직접 만든 커스텀 어노테이션
     */
    @GetMapping("/my_information")
    public StoreUserResponse myInformation(
            @Parameter(hidden = true)
            @AuthenticationPrincipal UserSession userSession
    ){

        return storeUserConverter.toResponse(userSession);
    }
}
