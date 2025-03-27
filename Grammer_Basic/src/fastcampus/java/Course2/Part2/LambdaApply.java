package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.StringOperation;

public class LambdaApply {
    public static void main(String[] args) {

        String input = "hello WOrld";

        //람다 표현식으로 모든 문자를 대문자로 변환하는 StringOperation 구현
        StringOperation toUpperCase = String::toUpperCase;

        //람다 표현식으로 모든 문자를 소문자로 변환하는 StringOperation 구현
        StringOperation toLowerCase = s->s.toLowerCase();

        //processString 메서드에 람다 표현식을 전달하여 결과를 출력
        System.out.println("toUpperCase: " + processString(input, toUpperCase));
        System.out.println("toLowerCase: " + processString(input, toLowerCase));
    }

    //람다 표현식을 인자로 사용하는 메서드를 작성
    public static String processString(String input, StringOperation operation){
        return operation.apply(input);
    }
}
