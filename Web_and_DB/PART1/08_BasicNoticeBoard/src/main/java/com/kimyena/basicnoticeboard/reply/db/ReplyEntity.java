package com.kimyena.basicnoticeboard.reply.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kimyena.basicnoticeboard.post.db.PostEntity;
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

    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private PostEntity post; // post + _id => post_id

    private String userName;

    private String password;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT") //db에서 `content` TEXT NULL로 선언해줬기 떄문에, String은 varchar로 인식
    private String content;

    private LocalDateTime repliedAt;
}
