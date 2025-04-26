package org.delivery.api.domain.user.controller;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.UserSession;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.user.business.UserBusiness;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.api.domain.user.model.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import java.util.Objects;

/**
 * (로그인 했음)
 *
 * 클라이언트:
 *   GET /api/user/me
 *   Header: Authorization-Token: "eyJhbGciOi..."
 *
 * 서버:
 *   1. Interceptor가 헤더에서 토큰 꺼냄
 *   2. 토큰 검증 (userId 추출)
 *   3. RequestContextHolder에 userId 저장
 *   4. Controller에서 userId 꺼냄
 *   5. UserBusiness.me(userId) 호출
 *   6. UserService.getUserWithThrow(userId) 호출
 *   7. DB에서 사용자 조회
 *   8. 조회된 사용자 정보 응답
 */
@RestController
@RequestMapping("/api/user") //로그인된 사용자가 들어오는 컨트롤러
@RequiredArgsConstructor
public class UserApiController {

    private final UserBusiness userBusiness;

    @GetMapping("/me")
    public Api<UserResponse> me(@UserSession User user){

        /*//requestContext는 request가 하나 들어올 때마다 생성된다. request가 들어오면 filter > interceptor > controller 갔다가 response 나갈 때까지 유지되는 global한 영역
        var requestContext = Objects.requireNonNull(RequestContextHolder.getRequestAttributes());

        // 이 값을 저장할 때,SCOPE_REQUEST 단위로 딱 한번만 저장할 건지 또는 sesison으로 할건지 설정할 수 있다.
        var userId = requestContext.getAttribute("userId", RequestAttributes.SCOPE_REQUEST);*/

        var response = userBusiness.me(user.getId());

        return Api.OK(response);
    }
}
