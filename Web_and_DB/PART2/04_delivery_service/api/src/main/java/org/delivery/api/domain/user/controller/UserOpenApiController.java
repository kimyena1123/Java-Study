package org.delivery.api.domain.user.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.delivery.api.common.api.Api;
import org.delivery.api.domain.token.controller.model.TokenResponse;
import org.delivery.api.domain.user.business.UserBusiness;
import org.delivery.api.domain.user.controller.model.UserLoginRequest;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Api<T>로 감싸는 이유
 * 요청(Request)과 응답(Response)을 '항상 같은 모양'으로 만들기 위해서.
 * 요즘 백엔드에서는 무조건 "응답 포맷 통일"을 중요하게 생각한다.
 * 예를 들면, 클라이언트(앱, 웹) 입장에서 서버 응답이 매번 다르면 파싱하기 진짜 힘들다. 그래서 "우리는 항상 이런 형태로 응답하겠습니다." 라고 정하는 것이다.
 * {
 *         "result": {
 *         "resultCode": "OK",
 *                 "resultMessage": "성공"
 *     },
 *         "body": {
 *         "이 안에 실제 데이터가 들어감"
 *         }
 *     }
 * 즉, "Api<T>로 항상 똑같은 껍데기를 유지하고, 그 안에만 데이터(body)를 넣겠다"는 약속.
 */

@RestController
@RequestMapping("/open-api/user")
@RequiredArgsConstructor
public class UserOpenApiController {

    private final UserBusiness userBusiness;

    //사용자 가입 요청
    @PostMapping("/register")
    public Api<UserResponse> register(
            @Valid
            @RequestBody Api<UserRegisterRequest> request
    ){
        var response = userBusiness.register(request.getBody());

        return Api.OK(response);
    }

    //사용자 로그인
    @PostMapping("/login")
    public Api<TokenResponse> login(
            @Valid
            @RequestBody Api<UserLoginRequest> request
    ){
        var response = userBusiness.login(request.getBody());

        return Api.OK(response);
    }
}
