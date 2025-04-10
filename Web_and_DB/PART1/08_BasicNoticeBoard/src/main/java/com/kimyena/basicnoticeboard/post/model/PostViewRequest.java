package com.kimyena.basicnoticeboard.post.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class PostViewRequest { //게시물을 보려고 한 개의 게시물 클릭 -> 비밀번호 입력 후 볼 수 있음

    @NotNull
    private Long postId;

    @NotBlank
    private String password;
}
