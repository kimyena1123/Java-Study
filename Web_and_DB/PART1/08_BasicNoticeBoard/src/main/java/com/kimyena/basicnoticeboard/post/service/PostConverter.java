package com.kimyena.basicnoticeboard.post.service;

import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.model.PostDto;
import org.springframework.stereotype.Service;

@Service
public class PostConverter {

    public PostDto toDto(PostEntity postEntity){
        return PostDto.builder()
                .id(postEntity.getId())
                .userName(postEntity.getUserName())
                .status(postEntity.getStatus())
                .email(postEntity.getEmail())
                .password(postEntity.getPassword())
                .title(postEntity.getTitle())
                .content(postEntity.getContent())
                .postedAt(postEntity.getPostedAt())
                .boardId(postEntity.getBoard().getId())
                .build();
    }
}
