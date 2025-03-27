package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.Pair;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class JavaProvideFunctionalInterfaceTest {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Doe");

        //String 클래스의 compareTo 메서드 참조
        Collections.sort(names, String::compareTo);
        System.out.println(names);// [Doe, Jane, John] <- 대괄호 안에 들어가 있는 형식이 List 형식

        for(String name: names) {
            System.out.println(name);
        }
    }
}
