package com.kimyena.validation.exception;

import com.kimyena.validation.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ValidationExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity<Api> validationException(
            MethodArgumentNotValidException exception
    ){
        log.error("", exception);

        var errorMessageList = exception.getFieldErrors().stream() //bindingResult에 에러가 난 필드들을 가져온다. (스트림을 통해서 가져온다)
                .map(it -> { // 각각 하나씩 값을 변환시킨다(map : 값을 변환할 때 사용한다)
                    var format = "%s : { %s }은 %s "; //해당 필드에, 어떠한 값은, 이러한 이유로 reject 당했다

                    //그래서 String format으로 format 넣어주고, 어떤 필드가, 어떠한 값을 요청했기 때문에, 값이 통과할 수 없었다
                    var message = String.format(format, it.getField(), it.getRejectedValue(), it.getDefaultMessage());

                    return message;
                }).toList(); //라는 것을 List로 만든다

        //그리고 Api error에 들어갈 에러를 만든다
        var error =Api.Error.builder()
                .errorMessage(errorMessageList)
                .build();

        var errorResopnse = Api.builder()
                .resultCode(String.valueOf(HttpStatus.BAD_REQUEST.value()))
                .resultMessage(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .Error(error)
                .build();

        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorResopnse);
    }
}
