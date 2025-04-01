package com.kimyena.exception.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api")
public class RestApiController {

    //http://localhost:8080/api
    @GetMapping(path = "")
    public void hello(){
        throw new RuntimeException("run time exception call"); //500 에러(서버에서 에러가 발생)
    }

    //http://localhost:8080/api/example`
    @GetMapping(path = "example1")
    public void example(){
        var list = List.of("hello");
        var element = list.get(1);

        log.info("element ; {}", element); //IndexOutOfBoundsException 에러 발생
    }

}
