package com.kimyena.exception.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice //Rest Api가 사용하는 곳에 예외가 일어나는 것을 감지한다.
public class RestApiExceptionHandler {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity exception(
            Exception e
    ){
        log.error("RestApiExceptionHandler" , e);

        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value = {IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(IndexOutOfBoundsException e){
        log.error("IndexOutOfBoundsException" , e);

        return ResponseEntity.status(200).build();
    }
}
