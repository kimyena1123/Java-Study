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
    public Api<UserRegisterRequest> register( //어떠한 타입인지는 모르겠지만, 걔는 Object를 상속받은 애를 리턴시킬거야
                                                          @Valid  //요청이 들어올 때, 자동으로 해당 클래스에 대해서 붙어있는 어노테이션 기반으로 검증해준다.
            @RequestBody
            Api<UserRegisterRequest> userRegisterRequest
    ){
        //오직 정상적인 로직만 두기
        log.info("init : {}", userRegisterRequest);


        var body = userRegisterRequest.getData();

        Api<UserRegisterRequest> response  = Api.<UserRegisterRequest>builder()
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.getReasonPhrase())
                .data(body)
                .build();

        return response;
    }
}
