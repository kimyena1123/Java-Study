package com.kimyena.validation.controller;

import com.kimyena.validation.model.Api;
import com.kimyena.validation.model.UserRegisterRequest;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@Slf4j
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    @PostMapping("")
    public ResponseEntity<Api<? extends Object>> register( //어떠한 타입인지는 모르겠지만, 걔는 Object를 상속받은 애를 리턴시킬거야
                                                          @Valid  //요청이 들어올 때, 자동으로 해당 클래스에 대해서 붙어있는 어노테이션 기반으로 검증해준다.
            @RequestBody
            Api<UserRegisterRequest> userRegisterRequest,

                                                          BindingResult bindingResult // 해당 Valid가 실행됐을 때, 해당 결과를 Binding result에 담아준다. 그래서 어떠한 내용이 있는지 확인
            ){
        log.info("init : {}", userRegisterRequest);

        //bindingResult를 통해서 에러가 있는지 검사한다. 그래서 에러를 가지고 있다면,
        if(bindingResult.hasErrors()){

            var errorMessageList = bindingResult.getFieldErrors().stream() //bindingResult에 에러가 난 필드들을 가져온다. (스트림을 통해서 가져온다)
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

            return errorResopnse;
        }



        var body = userRegisterRequest.getData();

        Api<UserRegisterRequest> response  = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;
    }
}
