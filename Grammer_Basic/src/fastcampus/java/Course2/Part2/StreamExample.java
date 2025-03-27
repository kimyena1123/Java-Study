package fastcampus.java.Course2.Part2;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class StreamExample {
    public static void main(String[] args) {
        //Arrays.asList()는 Arrays의 private 정적 클래스인 ArrayList를 리턴한다.
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        //자바에서 제공된 함수형 인터페이스를 사용한 짝수 여부 판별
        //Predicate: argument를 받아 boolean 값을 반환하는 함수형 인터페이스
        //Predicate<T>로 사용되고, 여기서 T는 파라미터이자 조건이다.
        //T가 true 또는 false를 return하도록 작성하면 된다
        Predicate<Integer> isEven = n -> n % 2 == 0;

        //스트림 API를 사용해 짝수만 필터링, 정렬, 제곱하고 합계를 계산
        int sumOfSquares = numbers.stream() //numbers 리스트는 스트림으로 변환
                .filter(isEven) // 짝수만 필터링 한다. 함수형 인터페이스인 Predicate 사용한다
                .sorted() // 정렬하낟
                .map(n->n*n) //각 숫자를 제곱한다(주어진 함수를 스트림의 모든 원소에 적용한 결과로 새로운 스트림을 생성)
                .reduce(0, Integer::sum); // 합계를 계산한다(스트림의 요소를 결합하여 하나의 결과값을 생성하는데 사용)
        //2, 4, 6, 8, 10 -> 4, 16, 36, 48, 100
        System.out.println("짝수의 제곱의 합: " + sumOfSquares);
    }
}
