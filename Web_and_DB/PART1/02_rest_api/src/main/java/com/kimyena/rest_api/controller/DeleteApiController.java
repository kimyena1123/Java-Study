package com.kimyena.rest_api.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api")
public class DeleteApiController {

    //http://localhost:8080/api/user/홍길동/delete  or  http://localhost:8080/api/user/홍길동/del
    @DeleteMapping(path = {
            "/user/{userName}/delete",
            "/user/{userName}/del"
    }) // @DeleteMapping("/user/{userName}/delete")
    public void delete( //delete는 주소에 pathvariable로도 받을 수 있고, query parameter도 받을 수 있다. 추천: path variable
                        @PathVariable String userName
    ){
        log.info("user-name: {}", userName);
    }
}
