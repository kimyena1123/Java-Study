package com.kimyena.basicnoticeboard.post.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
@Entity(name = "post")
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long boardId;

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT") //db에서 `content` TEXT NULL로 선언해줬기 떄문에, String은 varchar로 인식
    private String content;

    private LocalDateTime postedAt;


}
