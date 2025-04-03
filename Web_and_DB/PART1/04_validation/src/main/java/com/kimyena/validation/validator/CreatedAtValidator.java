package com.kimyena.validation.validator;

import com.kimyena.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Pattern;

public class CreatedAtValidator implements ConstraintValidator<YearMonth, String> {

    private String regexp;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
       this.regexp = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        boolean result = Pattern.matches(regexp, s);

        return result;
    }


}
