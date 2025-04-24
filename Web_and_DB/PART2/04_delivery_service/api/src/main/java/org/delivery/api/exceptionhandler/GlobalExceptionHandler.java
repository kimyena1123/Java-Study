package org.delivery.api.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MAX_VALUE) //순서지정: 값이 낮을수록 우선순위가 높아진다.(음수도 가능함) 값이 높을수록 나중에 실행된다. 기본값: MAX_VALUE
public class GlobalExceptionHandler {

    //모든 예외 받기
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Api<Object>> exception(Exception exception){ //모든 에러는 이쪽으로 오게 되어 있다.
        log.error("", exception);

        return ResponseEntity
                .status(500)
                .body(
                        Api.ERROR(ErrorCode.SERVER_ERROR)
                );
    }
}
