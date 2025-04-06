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
//        userService.delete(userId);
    }

    //GET http://localhost:8080/api/user/greater-then/score?score=70
    //매개변수의 점수보다 같거나 큰 경우의 정보를 리턴
    @GetMapping("/greater-then/score")
    public List<UserEntity> filterScore(
            @RequestParam int score
    ){
        return userService.filterScore(score);
    }

    //GET http://localhost:8080/api/user/min_max?min=30&max=90
    //매개변수의 점수보다는 크고, 특정 점수보다는 작은
    @GetMapping("/min_max")
    public List<UserEntity> filterScore(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.filterScore(min, max);
    }

    //쿼리 메서드가 아닌 @Query로 jpql 문법사용해보기. 기능은 위 메서드와 똑같음
    @GetMapping("/min_max2")
    public List<UserEntity> score(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.score(min, max);
    }

    //쿼리 메서드도, jpql 문법도 아닌 sql(native sql)으로 접근해보기. 기능은 위 메서드와 똑같음
    @GetMapping("/native_sql")
    public List<UserEntity> score2(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.score2(min, max);
    }

    //쿼리 메서드도, jpql 문법도 아닌 sql(native sql)으로 접근해보기. 쿼리문에서 ? 대신 별명으로 대체하기
    @GetMapping("/native_sql2")
    public List<UserEntity> score3(
            @RequestParam int min,
            @RequestParam int max
    ){
        return userService.score3(min, max);
    }
}
