package com.kimyena.validation.annotation;

import com.kimyena.validation.validator.CreatedAtValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy =  {CreatedAtValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@NotBlank
//@Size(min = 8, max = 8) //사용자가 20250403이 아닌 2024-04-03으로 입력할 수도 있기에 이건 제외하자
public @interface YearMonth {

    String message() default "날짜 형식이 맞지 않습니다. ex) 20250403";

    //^\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) (0[0-9]|1[0-9]|2[0-3]):(0[1-9]|[0-5][0-9]):(0[1-9]|[0-5][0-9])$
    String pattern() default "yyyyMM";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}