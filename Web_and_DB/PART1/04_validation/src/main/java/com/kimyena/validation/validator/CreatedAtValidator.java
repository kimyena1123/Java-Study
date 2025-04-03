package com.kimyena.validation.validator;

import com.kimyena.validation.annotation.YearMonth;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class CreatedAtValidator implements ConstraintValidator<YearMonth, String> {

    private String pattern;

    @Override
    public void initialize(YearMonth constraintAnnotation) {
       this.pattern = constraintAnnotation.pattern();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        //"2025-04-03T21:32:28" -> yyyy-MM-ddTHH:mm:ss
        //"202504" <- 6개의 문자
        //size = 6

        /* 이러한 형식은 어노테이션으로 이미 존재하기에, YearMonth Annotaion에서 따로 지정해주자
        if(value == null){
            return false;
        }

        if(value.length() != 8){
            return false;
        }
        */

        //검증: yyyy MM dd
        var reValue = value + "01";
        var rePattern = pattern + "dd";

        try{
            //어떠한 문자열로부터 LocalDate를 만들어낼거다.
            LocalDate date = LocalDate.parse(reValue, DateTimeFormatter.ofPattern(rePattern));
            //우리는 yyyyMM까지만 받을거다. 필요하다
            System.out.println(date);

            return true;
        }catch(Exception e){
            return false;
        }


    }


}
