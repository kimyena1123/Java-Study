package fastcampus.java.Course2.Part2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StreamMapExample2 {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("apple", "banana", "cherry", "orange");

        //스트림의 각 원소를 대문자로 변환한 후 새로운 리스트 생성
        List<String> wordsUpperList = words.stream()
                .map(String::toUpperCase) //lambda
                .toList();

        System.out.println("대문자로 변환한 리스트: " + wordsUpperList); //[APPLE, BANANA, CHERRY, ORANGE]

        for(String word : wordsUpperList) {
            System.out.println(word);
        }
    }
}
