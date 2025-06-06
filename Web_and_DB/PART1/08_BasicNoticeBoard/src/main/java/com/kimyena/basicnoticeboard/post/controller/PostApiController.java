package com.kimyena.basicnoticeboard.post.controller;

import com.kimyena.basicnoticeboard.common.Api;
import com.kimyena.basicnoticeboard.crud.CRUDAbstractApiController;
import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.model.PostDto;
import com.kimyena.basicnoticeboard.post.model.PostRequest;
import com.kimyena.basicnoticeboard.post.model.PostViewRequest;
import com.kimyena.basicnoticeboard.post.service.PostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
@RequiredArgsConstructor
public class PostApiController extends CRUDAbstractApiController<PostDto, PostEntity> {

    /*private final PostService postService;

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
    //GetMapping에서 특정 데이터를 필터링 하고 싶을 떄, query parameter 연결한다.
    @GetMapping("/all") //http://localhost:8080/api/post/all
    public Api<List<PostEntity>> list(
            @PageableDefault(page = 0, size = 10, sort = "id", direction = Sort.Direction.DESC) //페이지는 0번부터 시작, 총 size, 정렬할 변수, 정렬방법
            Pageable pageable
    ){
        return postService.all(pageable);
    }

    //게시물 삭제 - 비밀번호를 입력해서 게시물 삭제해야 함
    @PostMapping("/delete") //http://loocalhost:8080/api/post/delete
    public void delete(
            @Valid
            @RequestBody PostViewRequest postViewRequest
    ){
        postService.delete(postViewRequest);
    }*/

}
