package com.kimyena.basicnoticeboard.reply.db;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity(name = "reply")
public class ReplyEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long postId;

    private String userName;

    private String password;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT") //db에서 `content` TEXT NULL로 선언해줬기 떄문에, String은 varchar로 인식
    private String content;

    private LocalDateTime repliedAt;
}
