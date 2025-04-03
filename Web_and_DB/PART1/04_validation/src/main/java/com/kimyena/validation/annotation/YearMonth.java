package com.kimyena.validation.annotation;

import com.kimyena.validation.validator.CreatedAtValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy =  {CreatedAtValidator.class})
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface YearMonth {

    String message() default "날짜 형식이 맞지 않습니다. ex) YYYY-MM-DD HH:mm:ss";

    String regexp() default "^\\d{4}-(0[1-9]|1[012])-(0[1-9]|[12][0-9]|3[01]) (0[0-9]|1[0-9]|2[0-3]):(0[1-9]|[0-5][0-9]):(0[1-9]|[0-5][0-9])$";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}