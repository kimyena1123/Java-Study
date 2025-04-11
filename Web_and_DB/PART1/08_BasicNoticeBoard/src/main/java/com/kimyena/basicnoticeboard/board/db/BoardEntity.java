package com.kimyena.basicnoticeboard.board.db;

import com.kimyena.basicnoticeboard.post.db.PostEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DialectOverride;
import org.hibernate.annotations.SQLRestriction;
import org.hibernate.annotations.Where;

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
    @SQLRestriction("status = 'REGISTERED'") // @Where 어노테이션이 deprecated 되고, 그 대안책으로 사용되는 것이 @SQLRestriction
    @OrderBy("id desc")
    @Builder.Default
    private List<PostEntity> postList = List.of();
}
