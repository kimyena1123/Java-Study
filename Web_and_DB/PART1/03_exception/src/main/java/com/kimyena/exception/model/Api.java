package com.kimyena.exception.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder //객체 생성
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class Api<T> {

    private String resultCode;
    private String resultMessage;
    private T data; //제너릭 타입을 통해서 해당 data가 항상 바뀔 수 있도록 지정 -> ex) Api<UserResponse> -> id, name, age 가 data라는 박스에 한묶음 생김


}
