package com.kimyena.rest_api.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // snake case로 표현해준다.
public class UserRequest {
    private String userName;
    private Integer user_age;
    private String user_email;
    private Boolean isKorean; //is_korean


    public String name(){
        return this.userName;
    }

    public int humanAge(){
        return this.user_age;
    }

    @Override
    public String toString() {
        return "UserRequest{" +
                "userName='" + userName + '\'' +
                ", user_age=" + user_age +
                ", user_email='" + user_email + '\'' +
                ", isKorean=" + isKorean +
                '}';
    }
}
