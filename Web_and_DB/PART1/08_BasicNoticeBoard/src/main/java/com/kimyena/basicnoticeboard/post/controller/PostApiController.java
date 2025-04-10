package com.kimyena.basicnoticeboard.post.controller;

import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.model.PostRequest;
import com.kimyena.basicnoticeboard.post.model.PostViewRequest;
import com.kimyena.basicnoticeboard.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController {

    private final PostService postService;

    //게시물 생성
    @PostMapping("") //http://localhost:8080/api/post
    public PostEntity create(
            @Valid
            @RequestBody PostRequest postRequest
    ){
        return postService.create(postRequest);
    }

    //게시판 보기 - 한 개만 : 비밀번호를 입력한 후 게시물을 볼 수 있음.
    @PostMapping("/view")
    public PostEntity view(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ){
        return postService.view(postViewRequest);
    }

    //게시판 보기 - 여러 개
    @GetMapping("/all") //http://localhost:8080/api/post/all
    public List<PostEntity> list(){
        return postService.all();
    }

    //게시물 삭제 - 비밀번호를 입력해서 게시물 삭제해야 함
    @PostMapping("/delete") //http://loocalhost:8080/api/post/delete
    public void delete(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ){
        postService.delete(postViewRequest);
    }

}
