package com.kimyena.basicnoticeboard.post.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.kimyena.basicnoticeboard.board.db.BoardEntity;
import com.kimyena.basicnoticeboard.reply.db.ReplyEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

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

//    private Long boardId;
    @ManyToOne
    @JsonIgnore
    @ToString.Exclude
    private BoardEntity board; // board + _id => board_id

    private String userName;

    private String password;

    private String email;

    private String status;

    private String title;

    @Column(columnDefinition = "TEXT") //db에서 `content` TEXT NULL로 선언해줬기 떄문에, String은 varchar로 인식
    private String content;

    private LocalDateTime postedAt;

    //게시물을 보여줄 때 댓글도 같이 보여줘야 하기에
    @OneToMany(
            mappedBy = "post"
    )
    private List<ReplyEntity> replyList = Arrays.asList();
}
