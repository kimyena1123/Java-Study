package com.kimyena.basicnoticeboard.post.service;

import com.kimyena.basicnoticeboard.board.db.BoardRepository;
import com.kimyena.basicnoticeboard.crud.Converter;
import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.model.PostDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PostConverter implements Converter<PostDto, PostEntity> {

    private final BoardRepository boardRepository;

    @Override
    public PostDto toDTO(PostEntity postEntity) {
        //entity를 dto로 변환
        return PostDto.builder()
                .id(postEntity.getId())
                .boardId(postEntity.getBoard().getId())
                .userName(postEntity.getUserName())
                .password(postEntity.getPassword())
                .email(postEntity.getEmail())
                .status(postEntity.getStatus())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .postedAt(postEntity.getPostedAt())
                .build();
    }

    @Override
    public PostEntity toEntity(PostDto postDto) {

        var boardEntity = boardRepository.findById(postDto.getBoardId());

        //dto를 entity로 변환.
        return PostEntity.builder()
                .id(postDto.getId())
                .board(boardEntity.orElse(null))
                .userName(postDto.getUserName())
                .password(postDto.getPassword())
                .email(postDto.getEmail())
                .status((postDto.getStatus() != null) ? postDto.getStatus() : "REGISTERED")
                .title(postDto.getTitle())
                .content(postDto.getContent())
                .postedAt((postDto.getPostedAt() != null) ? postDto.getPostedAt() : LocalDateTime.now())
                .build();
    }
}
