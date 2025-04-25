package org.delivery.api.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.api.domain.user.controller.model.UserLoginRequest;
import org.delivery.api.domain.user.controller.model.UserRegisterRequest;
import org.delivery.api.domain.user.controller.model.UserResponse;
import org.delivery.api.domain.user.converter.UserConverter;
import org.delivery.api.domain.user.service.UserService;

import java.util.Optional;

@Business // 내가 만든 커스텀 어노테이션
@RequiredArgsConstructor
/**
 * Service와 Business의 차이. 왜 분리해놓았는지(DDD구조, Layered Architecture)
 *
 * UserService는 "유저 생성 요청이 왔다 → 유효성 검사 → 유저 비즈니스 호출 → 응답 만들기" 를 조율하고
 * UserBusiness는 "유효한 유저인지 체크", "중복 여부 체크", "DB 저장" 이런 실제 로직을 담당해.
 *
 * Controller로 사용자 오청이 들어오면 -> Controller는 Business한테 요청을 하고 -> Business는 Service한테 요청하고 -> Service는 최종 DB인 Repository에다가 요청하게 된다.
 */
public class UserBusiness { // 복잡한 로직들을 처리할 거다.

    private final UserService userService;
    private final UserConverter userConverter;

    //사용자에 대한 가입처리 로직: 해당 request를 entity로 바꿔주고 entity가 저장되면 된다.
    //1. request -> entity로 바꿔주고
    //2. entity를 save 하고 : UserService가 해준다.
    //3. save된 entity를 -> response로 바꾸고
    //4. response를 return한다.
    public UserResponse register(UserRegisterRequest request){

        //1. request -> entity로 바꿔주기
        var entity = userConverter.toEntity(request);

        //2. 바꾼 entity를 UserService로 보내서 save하기
        var newEntity = userService.register(entity);

        //3. save된 entity를 Converter를 통해 response로 바꾼다
        var response = userConverter.toResponse(newEntity);


        //위 내용을 람다식으로 표현
        /*return Optional.ofNullable(request)
                .map(userConverter::toEntity)
                .map(userService::register)
                .map(userConverter::toResponse)
                .orElseThrow(()-> new ApiException(ErrorCode.NULL_POINT, "request Null"));*/

        //4. 해당 response를 return한다
        return response;
    }

    /**
     * 1. email과 password를 가지고 사용자 체크
     * 2. user eneity가 떨어지면 로그인 확인을 한다.
     * 3. 로그인을 하면 token 생성
     * 4. token을 resopnse로 내려주면 된다.
     */
    public UserResponse login(UserLoginRequest request){
        //1. 사용자 체크
        var userEntity = userService.login(request.getEmail(), request.getPassword()); //사용자 없으면 throw가 발생

        // TODO 사용자가 있으면 token 생성

        return userConverter.toResponse(userEntity);
    }
}
