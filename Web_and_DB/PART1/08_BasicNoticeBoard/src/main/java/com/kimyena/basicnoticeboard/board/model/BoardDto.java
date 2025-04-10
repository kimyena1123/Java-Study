package com.kimyena.basicnoticeboard.board.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kimyena.basicnoticeboard.post.db.PostEntity;
import com.kimyena.basicnoticeboard.post.model.PostDto;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class BoardDto { //BoardEntity와 동일한 형태일 것이다.

    private Long id;

    private String boardName;

    private String status;

    private List<PostDto> postList = List.of();
}
