package org.delivery.api.common.error;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * User의 경우 1000번대 에러 코드 사용
 */
@AllArgsConstructor
@Getter // ErrorCode 클래스에서는 세 개의 메소드 다 override 했다. 그렇게 해도 되지만, 이렇게 @Getter로 해줘도 된다.
public enum UserErrorCode implements ErrorCodeInterface{

    USER_NOT_FOUND(400, 1404, "사용자를 찾을 수 없음."),
    ;

    private final Integer httpStatusCode;

    private final Integer errorCode;

    private final String description;

}
