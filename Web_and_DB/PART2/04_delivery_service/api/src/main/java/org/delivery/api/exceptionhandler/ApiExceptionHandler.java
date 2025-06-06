package org.delivery.api.exceptionhandler;

import lombok.extern.slf4j.Slf4j;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.exception.ApiException;
import org.springframework.core.annotation.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
@Order(value = Integer.MIN_VALUE)
public class ApiExceptionHandler {

    @ExceptionHandler(ApiException.class) //ApiException에서 발생하는 모든 예외 캐치
    public ResponseEntity<Api<Object>> apiException(ApiException apiException){
        log.error("", apiException);

        var errorCode = apiException.getErrorCodeInterface();

        System.out.println("ApiExceptionHandler class > errorCode : " + errorCode);

        return ResponseEntity
                .status(errorCode.getHttpStatusCode())
                .body(
                        Api.ERROR(errorCode, apiException.getErrorDescription())
                );
    }
}
