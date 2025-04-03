package com.kimyena.validation.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.kimyena.validation.annotation.PhoneNumber;
import com.kimyena.validation.annotation.YearMonth;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)

//@NotNull // Null을 허용하지 X
//@NotEmpty // Null을 허용하지 X + 비어있는 값이 아니여야 한다
//@NotBlank //Null을 허용하지 X + 비어있는 값이 아니여야 한다 + 공백 X
public class UserRegisterRequest {

    //@NotBlank
    private String name;

    //name이나 nickName 둘 중 하나라도 있으면 통과시키게 하고 싶다. 그러한 어노테이션은 없기 때문에 따로 만들어줘야 한다
    private String nickName;

    @NotBlank
    @Size(min = 1, max = 12) //1~12
    private String password;

    @NotNull // 문자열이 아니기 때문에 NotBlank X
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    //@Pattern(regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$", message = "휴대폰 번호가 양식에 맞지 않습니다") //정규식 사용
    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt; //"register_at": "2025-04-02T18:00:00" 형식

    @YearMonth(pattern = "yyyy-MM") //"birth_day_year_month":"2025-04"
    private String birthDayYearMonth;

    @AssertTrue(message = "name or nickName 둘 중 하나는 반드시 1개는 존재해야 합니다.") //@AsserTrue는 is라는 메서드에 반드시 붙여줘야 한다
    public boolean isNameCheck(){

        if(Objects.nonNull(name) & name.isBlank()){ // name Object가 Null값이 아니여야 하고, name이 blank가 아니라면
            return true;
        }

        if(Objects.nonNull(nickName) & nickName.isBlank()){
            return true;
        }

        return false;
    }
}
