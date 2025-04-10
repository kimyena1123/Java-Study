package com.kimyena.basicnoticeboard.board.controller;

import com.kimyena.basicnoticeboard.board.db.BoardEntity;
import com.kimyena.basicnoticeboard.board.model.BoardRequest;
import com.kimyena.basicnoticeboard.board.service.BoardService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/board")
@RequiredArgsConstructor
public class BoardApiController { //요청을 받기 위해선 model 필요

    private final BoardService boardService;

    @PostMapping("") //http://localhost:8080/api/board
    public BoardEntity create(
            @Valid
            @RequestBody BoardRequest boardRequest
    ){
        return boardService.create(boardRequest);
    }
}
