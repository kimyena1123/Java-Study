package com.kimyena.memorydb.user.model;

import com.kimyena.memorydb.entity.Entity;
import lombok.*;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserEntity extends Entity { //UserEntity는 DB에 저장될 아이이기 때문에, 상속받는다.
    private String name;
    private int score;
}
