package com.kimyena.jpa.user.db;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "user") // "user"테이블과 매핑시키겠다는 의미
public class UserEntity {

    //해당 UserEntity 클래스(객체)를 데이터베이스와 매핑할 거다.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //mysql 같은 경우는 IDENTITY
    private Long id;

    private String name;

    private Integer age;

    private String email;
}
