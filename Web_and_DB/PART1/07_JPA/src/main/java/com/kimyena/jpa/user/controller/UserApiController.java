package com.kimyena.jpa.user.controller;

import com.kimyena.jpa.user.db.UserEntity;
import com.kimyena.jpa.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
public class UserApiController {

    private final UserRepository userRepository; //@RequiredArgsConstructor

    //read
    @GetMapping("/find-all")
    public List<UserEntity> findAll(){
        return userRepository.findAll();
    }

    //create : 이름만 받아서 저장하기
    @GetMapping("/name") //http://localhost:8080/api/user/name?name=김예나
    public void autoSave(
            @RequestParam String name
    ){
        var user = UserEntity.builder()
                .name(name)
                .build();

        userRepository.save(user);
    }
}
