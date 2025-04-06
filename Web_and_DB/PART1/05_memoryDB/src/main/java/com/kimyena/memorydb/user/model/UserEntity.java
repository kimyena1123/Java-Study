package com.kimyena.memorydb.user.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user") //name에 들어갈 값은 table의 이름이다.
public class UserEntity { //UserEntity는 DB에 저장될 아이이기 때문에, 상속받는다.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private int score;
}
