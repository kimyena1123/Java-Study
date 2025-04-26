package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Token의 경우 2000번대 에러 코드 사용
 */
@AllArgsConstructor
@Getter // ErrorCode 클래스에서는 세 개의 메소드 다 override 했다. 그렇게 해도 되지만, 이렇게 @Getter로 해줘도 된다.
public enum TokenErrorCode implements ErrorCodeInterface{ //각각은 에러의 구체적인 사례를 Enum으로 관리

    //인터페이스 규칙을 따르고 있다.
    INVALID_TOKEN(400, 2000, "유효하지 않은 토큰"), //HTTP 응답: 400, 에러 코드: 2000, 메시지: "유효하지 않은 토큰"
    EXPIRED_TOKEN(400, 2001, "만료된 토큰"), //HTTP 응답: 400, 에러 코드: 2001, 메시지: "만료된 토큰"
    TOKEN_EXCEPTION(400, 2002, "알 수 없는 토큰 에러"), //HTTP 응답: 400, 에러 코드: 2002, 메시지: "알 수 없는 토큰 에러"
    AUTHORIAZATION_TOKEN_NOT_FOUND(400, 2003, "인증 헤더 토큰 없음"),
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;

}
