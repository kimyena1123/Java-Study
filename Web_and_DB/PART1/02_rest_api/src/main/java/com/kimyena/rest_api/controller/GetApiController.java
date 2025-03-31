package com.kimyena.rest_api.controller;

import com.kimyena.rest_api.model.BookQueryParam;
import org.springframework.web.bind.annotation.*;

@RestController //Rest API를 처리하는 Controller
@RequestMapping("/api") //어떠한 주소를 받는지 지정
public class GetApiController {

    @GetMapping(path = "/hello") // http://localhost:8080/api/hello
    public String hello(){
        var html = "<html><body><h1>Hello Spring Boot</h1></body></html>";

        return html;
    }

    @GetMapping(path = "/echo/{message}") //http://localhost:8080/api/{message}
    public String echo(@PathVariable String message ){
        System.out.println("echo message : " + message);

        return message;
    }

    @GetMapping(path = "/echo2/{message}") //http://localhost:8080/api/{message}
    public String echo2(@PathVariable(name = "message") String msg){
        System.out.println("echo message : " + msg);

        // TODO 대문자로 변환해서 RETURN
        msg = msg.toUpperCase();

        return msg;
    }

    @GetMapping(path = "/echo3/{message}//age/{age}/is-man/{isMan}") //http://localhost:8080/api/echo3/yena//age/25/is-man/false
    public String echo3(
            @PathVariable(name = "message") String msg,
            @PathVariable int age,
            @PathVariable boolean isMan){

        System.out.println("echo message : " + msg);
        System.out.println("echo age : " + age);
        System.out.println("echo isMan : " + isMan);

        // TODO 대문자로 변환해서 RETURN
        msg = msg.toUpperCase();
        // String 타입의 변수 외에 다른 타입 받아보기

        // boolean, integer

        return msg;
    }


    // 쿼리 파싱하는 방법1
    // http://localhost:8080/api/book?category=IT&issuedYear=2023&issued-month=01&issued_day=31
    @GetMapping(path = "/book")
    public void queryparam(
            @RequestParam String category,
            @RequestParam String issuedYear,
            @RequestParam(name = "issued-month") String issuedMonth,
            @RequestParam(name = "issued_day") String issuedDay
    ){
        System.out.println("category : " + category);
        System.out.println("issuedYear : " + issuedYear);
        System.out.println("issuedMonth : " + issuedMonth);
        System.out.println("issued_day : " + issuedDay);

    }

    // 쿼리 파싱하는 방법2: 객체 사용 <- 변수가 많을 때
    // http://localhost:8080/api/book2?category=IT&issuedYear=2023&issuedMonth=01&issuedDay=31
    @GetMapping(path = "/book2")
    public void queryparam2(
           BookQueryParam bookQueryParam
    ){
        System.out.println("category : " + bookQueryParam);

    }

    // TODO parameter 2개를 받는다. int 형태로 받아서 두 수의 덧셈, 곱셈을 리턴해주는 메서드 만들기
    // TODO String 타입, boolean 타입도 받아보기

}
