package com.kimyena.basicnoticeboard.board.controller;

import com.kimyena.basicnoticeboard.board.db.BoardEntity;
import com.kimyena.basicnoticeboard.board.model.BoardDto;
import com.kimyena.basicnoticeboard.board.model.BoardRequest;
import com.kimyena.basicnoticeboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController { //요청을 받기 위해선 model 필요

    private final BoardService boardService;

    //게시판 생성(예. Q&A 게시판, FAQ 게시판 등등..)
    @PostMapping("") //http://localhost:8080/api/board
    public BoardDto create(
            @Valid
            @RequestBody BoardRequest boardRequest
    ){
        return boardService.create(boardRequest);
    }

    //게시판 view를 띄울 때, 게시물도 같이 여러 개 보여야 한다.
    @GetMapping("/id/{id}") //http://localhost:8080/api/board/id/{id}
    public BoardDto view(
            @PathVariable Long id
    ){
        var entity = boardService.view(id);
        log.info("result: {}", entity);

        return boardService.view(id);

    }

}
