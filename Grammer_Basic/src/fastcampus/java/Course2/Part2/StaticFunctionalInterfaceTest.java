package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.Converter;
import fastcampus.java.Course2.Part2.model.IntegerUtils;

public class StaticFunctionalInterfaceTest {
    public static void main(String[] args) {
        Converter<String, Integer> converter = IntegerUtils::stringToInt;
        Integer result = converter.convert("123");

        System.out.println(result);
    }
}
