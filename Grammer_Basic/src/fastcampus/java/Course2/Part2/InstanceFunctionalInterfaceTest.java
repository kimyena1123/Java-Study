package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.Converter;
import fastcampus.java.Course2.Part2.model.StringUtils;

public class InstanceFunctionalInterfaceTest {
    public static void main(String[] args) {
        StringUtils stringUtils = new StringUtils();
        Converter<String, String> converter = stringUtils::reverse;
        String result = converter.convert("hello");

        System.out.println(result);
    }
}
