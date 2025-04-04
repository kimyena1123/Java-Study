package com.kimyena.memorydb.user.controller;

import com.kimyena.memorydb.user.model.UserEntity;
import com.kimyena.memorydb.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController// HTTP request가 들어오는 내용을 처리하고 response를 처리하는 영역이다.
@RequestMapping("/api/user")
@RequiredArgsConstructor //생성자 메서드
public class UserApiController {

    private final UserService userService;

    //create, update
    @PutMapping("")
    public UserEntity create(
            @RequestBody UserEntity userEntity //원래는 Entity를 Controller에서 받으면 안되지만, 지금 단계에서는 이렇게 하고 나중에 제대로 구현
    ){
        return userService.save(userEntity);
    }

    //read - 모두
    @GetMapping("/all")
    public List<UserEntity> findAll() {
        return userService.findAll();
    }

//    //read - 한개만
//    @GetMapping("/read/id/{userId}")
//    public Optional<UserEntity> findById(@PathVariable Long userId) {
//        return userService.findById(userId); //이런 식으로 해도 작성은 하지만 아래 방식을 추천
//    }

    //위 방식으로 해도 동작은 하지만, 아래 방식을 추천
    @GetMapping("/read/id/{userId}")
    public UserEntity findOne(
            @PathVariable Long userId
    ){
        var response = userService.findById(userId);
        return response.get();
    }

    //delete
    @DeleteMapping("/delete/id/{userId}")
    public void deleteById(
            @PathVariable Long userId
    ){
        userService.delete(userId);
    }
}
