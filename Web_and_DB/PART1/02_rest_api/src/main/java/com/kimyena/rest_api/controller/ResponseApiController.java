package com.kimyena.rest_api.controller;

import com.kimyena.rest_api.model.UserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController // 즉,응답값이 JSON으로 받겠다는 선언이다
// 스프링부트에는 반드시 json 응답만 있는 건 아니다. html 응답도 내려줄 수 있다. -> @Controller
//@RestController가 아닌 @Controller로 했는데, HTML 응답이 아니라 JSON 형태로 응답을 내려야 한다면, 메서드에(Mapping 메서드 아래에) @ResponseBody 어노테이션을 추가해주면 된다
@RequestMapping("api/v1")
public class ResponseApiController {

    // http://localhost:8080/api/v1
    @GetMapping("/json") //  @GetMapping(path = "") = @RequestMapping(path = "", method = RequestMethod.GET)
    public UserRequest user(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUser_age(10);
        user.setUser_email("hong@gamil.com");

        return user; //JSON 형식으로 나온다.
    }

    // http://localhost:8080/api/v1/string
    @GetMapping("/string")
    public String user2(){ // 이런 형식으로 하는 경우는 거의 없다.
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUser_age(10);
        user.setUser_email("hong@gamil.com");

        log.info("user: {} ", user);

        return user.toString(); //UserRequest(userName=홍길동, user_age=10, user_email=hong@gamil.com, isKorean=null) 형식으로 나온다.
    }

    // http://localhost:8080/api/v1
    @GetMapping("/responseentity") // ResponseEntity는 헤더도 커스텀할 수 있고 body의 내용도 바꿀 수 있고, status code도 원하는 코드로 해서 에러 처리할 수 있도록 할 수 있다
    public ResponseEntity<UserRequest> user3(){
        var user = new UserRequest();
        user.setUserName("홍길동");
        user.setUser_age(10);
        user.setUser_email("hong@gamil.com");

        log.info("user: {} ", user);

        var response = ResponseEntity
                .status(HttpStatus.BAD_REQUEST) //OK, CREATED
                .header("x-custom", "hi")
                .body(user);

        return response; // JSON 형태로 나온다
    }
}
