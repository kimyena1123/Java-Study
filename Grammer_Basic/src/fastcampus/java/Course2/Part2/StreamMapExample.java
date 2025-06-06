package fastcampus.java.Course2.Part2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamMapExample {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);

        //스트림의 각 원소를 제곱한 값으로 구성된 새로운 리스트 생성
        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .toList();

        System.out.println("재곱한 값의 리스트: " + squaredNumbers); //[1, 4, 9, 16, 25]
    }
}
