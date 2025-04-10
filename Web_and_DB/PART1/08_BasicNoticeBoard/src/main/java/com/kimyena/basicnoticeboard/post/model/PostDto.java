package com.kimyena.basicnoticeboard.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kimyena.basicnoticeboard.board.db.BoardEntity;
import com.kimyena.basicnoticeboard.reply.db.ReplyEntity;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostDto {

    private Long id;

    private Long boardId;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    private String content;

    private LocalDateTime postedAt;

}
