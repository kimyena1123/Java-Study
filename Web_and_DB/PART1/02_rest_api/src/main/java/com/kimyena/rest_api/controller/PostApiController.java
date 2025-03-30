package com.kimyena.rest_api.controller;

import com.kimyena.rest_api.model.BookRequest;
import com.kimyena.rest_api.model.UserRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class PostApiController { //POST 방식은 데이터를 받을 때, defulat가 객체로 받아야 한다.(Get은 객체 없이 또는 query param를 객체로 받았었다)

    @PostMapping("/post") // http://localhost:8080/api/post
    public String post(
            //RequestBody은 POST 방식에서 http body로 들어오는 데이터를 해당 객체에다가 매핑해주겠다는 의미.
            @RequestBody BookRequest bookRequest
            ){
        System.out.println(bookRequest);

        return bookRequest.toString();
    }


    @PostMapping("/user")
    public UserRequest userInfo(
            @RequestBody UserRequest user
    ){
        System.out.println("user object: " + user);

        return user;
    }


}
