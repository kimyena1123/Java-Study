package org.delivery.api.account;

import lombok.RequiredArgsConstructor;
import org.delivery.api.account.model.AccountMeResponse;
import org.delivery.api.common.api.Api;
import org.delivery.api.common.error.ErrorCode;
import org.delivery.api.common.error.UserErrorCode;
import org.delivery.api.common.exception.ApiException;
import org.delivery.db.account.AccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountApiController {

    private final AccountRepository accountRepository;

    @GetMapping("/me1")
    public Api<AccountMeResponse> me(){
        var response = AccountMeResponse.builder()
                .name("홍길동")
                .email("A@gmail.com")
                .registeredAt(LocalDateTime.now()) //ISO 8601 국제표준 형식
                .build();


        return Api.OK(response);
    }

    @GetMapping("/me2/errorcheck")
    public Api<Object> me_errorcheck(){
        var response = AccountMeResponse.builder()
                .name("가나다")
                .email("A@gmail.com")
                .registeredAt(LocalDateTime.now()) //ISO 8601 국제표준 형식
                .build();


        return Api.ERROR(UserErrorCode.USER_NOT_FOUND, "가나다 라는 사용자 없음");
        ///Response body >> { "result_code": 1404, "result_message": "사용자를 찾을 수 없음.","result_description": "가나다 라는 사용자 없음"}
    }

    @GetMapping("/me3/exceptioncheck")
    public Api<AccountMeResponse> me_exceptioncheck(){
        var response = AccountMeResponse.builder()
                .name("가나다")
                .email("A@gmail.com")
                .registeredAt(LocalDateTime.now()) //ISO 8601 국제표준 형식
                .build();

        //예외 주기
        var str = "안녕하세요";
        var age = Integer.parseInt(str); //예외 발생

        return Api.OK(response);
    }

    @GetMapping("/me4/apiexceptioncheck")
    public Api<AccountMeResponse> me_apiexceptioncheck(){
        var response = AccountMeResponse.builder()
                .name("가나다")
                .email("A@gmail.com")
                .registeredAt(LocalDateTime.now()) //ISO 8601 국제표준 형식
                .build();

        //예외 주기
        var str = "안녕하세요";
        var age = 0;

        try{
            Integer.parseInt(str);
        }catch(Exception e){
            throw new ApiException(ErrorCode.SERVER_ERROR, e, "사용자 Me 호출시 에러 발생");
        }

        return Api.OK(response);
    }
}
