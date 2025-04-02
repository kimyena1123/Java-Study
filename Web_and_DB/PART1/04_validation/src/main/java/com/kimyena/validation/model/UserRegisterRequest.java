package com.kimyena.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)

//@NotNull // Null을 허용하지 X
//@NotEmpty // Null을 허용하지 X + 비어있는 값이 아니여야 한다
//@NotBlank //Null을 허용하지 X + 비어있는 값이 아니여야 한다 + 공백 X
public class UserRegisterRequest {
    @NotBlank
    private String name;

    @NotBlank
    @Size(min = 1, max = 12) //1~12
    private String password;

    @NotNull // 문자열이 아니기 때문에 NotBlank X
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @Pattern(regexp = "\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호가 양식에 맞지 않습니다")
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt; //"register_at": "2025-04-02T18:00:00" 형식
}
