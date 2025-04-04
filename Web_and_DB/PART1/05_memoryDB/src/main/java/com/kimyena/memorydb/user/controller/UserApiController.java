package com.kimyena.memorydb.user.controller;

import com.kimyena.memorydb.user.model.UserEntity;
import com.kimyena.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// HTTP request가 들어오는 내용을 처리하고 response를 처리하는 영역이다.
@RequestMapping("/api/user")
@RequiredArgsConstructor //생성자 메서드
public class UserApiController {

    private final UserService userService;

    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity //원래는 Entity를 Controller에서 받으면 안되지만, 지금 단계에서는 이렇게 하고 나중에 제대로 구현
    ){
        return userService.save(userEntity);
    }

    //read
    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

}
