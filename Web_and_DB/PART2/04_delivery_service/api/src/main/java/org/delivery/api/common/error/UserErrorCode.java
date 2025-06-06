package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * User의 경우 1000번대 에러 코드 사용
 */
@AllArgsConstructor
@Getter // ErrorCode 클래스에서는 세 개의 메소드 다 override 했다. 그렇게 해도 되지만, 이렇게 @Getter로 해줘도 된다.
public enum UserErrorCode implements ErrorCodeInterface{ //각각은 에러의 구체적인 사례를 Enum으로 관리

    //인터페이스 규칙을 따르고 있다.
    USER_NOT_FOUND(400, 1404, "사용자를 찾을 수 없음."), ////HTTP 응답: 400, 에러 코드: 1404, 메시지: "사용자를 찾을 수 없음"
    ;

    private final Integer httpStatusCode;
    private final Integer errorCode;
    private final String description;

}
