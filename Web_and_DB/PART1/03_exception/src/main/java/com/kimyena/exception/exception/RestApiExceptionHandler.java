package com.kimyena.exception.exception;

import com.kimyena.exception.controller.RestApiBController;
import com.kimyena.exception.controller.RestApiController;
import com.kimyena.exception.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
//@RestControllerAdvice(basePackages = "com.kimyena.exception.controller") //Rest Api가 사용하는 곳에 예외가 일어나는 것을 감지한다. <- 모든 controller에서 나오는 예외를 잡아준다
@RestControllerAdvice(basePackageClasses = {RestApiController.class, RestApiBController.class})
@Order(1)
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("IndexOutOfBoundsException" , e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = NoSuchElementException.class)
    public ResponseEntity<Api> noSuchElement(NoSuchElementException e){
        log.error("NoSuchElementException" , e);

        var response =  Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
