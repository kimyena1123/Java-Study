package org.delivery.api.domain.user.business;

import lombok.RequiredArgsConstructor;
import org.delivery.api.common.annotation.Business;
import org.delivery.api.domain.user.converter.UserConverter;
import org.delivery.api.domain.user.service.UserService;

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
}
