package com.kimyena.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder //객체 생성 -> @Builder를 사용하여 빌더 패턴으로 객체 생성이 가능
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserResponse { //사용자의 ID, 이름, 나이를 저장하는 DTO (Data Transfer Object) 역할

    private String id;
    private String name;
    private Integer age;

}
