package com.kimyena.basicnoticeboard.board.service;

import com.kimyena.basicnoticeboard.board.db.BoardEntity;
import com.kimyena.basicnoticeboard.board.model.BoardDto;
import com.kimyena.basicnoticeboard.post.model.PostDto;
import com.kimyena.basicnoticeboard.post.service.PostConverter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class BoardConverter { //converter가 하는 역할: 데이터를 변환해주는 역할을 한다.

    private final PostConverter postConverter;

    //BoardEntity가 들어오면 BoardDto로 바꿔줄거다
    public BoardDto toDto(BoardEntity boardEntity){
        var postList = boardEntity.getPostList().stream()
                        .map(postEntity -> {
                            return postConverter.toDto(postEntity);
                        }).collect(Collectors.toList());

        return BoardDto.builder()
                .id(boardEntity.getId())
                .boardName(boardEntity.getBoardName())
                .status(boardEntity.getStatus())
                .postList(postList)
                .build();
    }
}
