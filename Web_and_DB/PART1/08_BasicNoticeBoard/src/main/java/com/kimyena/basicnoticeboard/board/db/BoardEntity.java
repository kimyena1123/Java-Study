package com.kimyena.basicnoticeboard.board.db;

import com.kimyena.basicnoticeboard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity(name = "board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String boardName;

    private String status;

    @OneToMany(
            mappedBy = "board"
    )
    private List<PostEntity> postList = List.of();
}
