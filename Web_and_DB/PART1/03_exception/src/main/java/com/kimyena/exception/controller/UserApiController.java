package com.kimyena.exception.controller;

import com.kimyena.exception.model.Api;
import com.kimyena.exception.model.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserApiController {

    //현재 DB를 사용하지 않기 때문에 사용자 데이터를 리스트로 미리 정의
    //List.of(...)를 사용하여 **불변 리스트(immutable list)**를 생성
    //빌더 패턴을 사용하여 UserResponse 객체를 생성하는 방식
    private static List<UserResponse> userList = List.of(
            //builder는 아래처럼 builder()라는 메서드로 시작해서 각각의 변수를 지정(id(), name(), age()를 지정하고 build()를 하게 되면
            //해당 객체가 하나 만들어지는 형태이다.
            //기존의 우리는 메서드에서 객체를 만든다하면, -> var user = new Response(); user.SetId(); user.SetName(); user.SetAge()를 해야 했다.
            //builder 패턴은 체이닝된 방식으로 마치 한가지를 빌드하듯이 이어지는 패턴을 말한다.
            UserResponse.builder().id("1").age(10).name("홍길동").build(),
            UserResponse.builder().id("2").age(20).name("나길동").build()
    );

    @GetMapping("/id/{userId}") //http://localhost:8080/api/user/id/1
    public Api<UserResponse> getUser(@PathVariable String userId){

        //userList를 stream()으로 변환하여 데이터를 필터링
        var user = userList.stream(). ////it : userList에 들어있는 위에 만들어진 객체를 의미(it은 리스트 내부의 각 UserResponse 객체)
                filter(it->it.getId().equals(userId)) //사용자의 ID가 userId와 일치하는 객체만 필터링
                .findFirst()
                .get(); //주의: 만약 일치하는 사용자가 없으면 예외 발생


        //API 응답 객체 생성
        Api<UserResponse> response = Api.<UserResponse>builder() //Api<UserResponse> 타입의 객체를 생성
                .resultCode(String.valueOf(HttpStatus.OK.value()))
                .resultMessage(HttpStatus.OK.name())
                .data(user) //data 필드에 찾은 user 객체를 설정
                .build();

        return response; //JSON 형태

        /*
        {
            "result_code": "200",
                "result_message": "OK",
                "data":{
            "id": "1",
                    "name": "홍길동",
                    "age": 10
            }
        }
         */
    }
}
