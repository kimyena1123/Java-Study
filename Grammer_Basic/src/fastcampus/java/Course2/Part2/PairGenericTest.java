package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.Pair;

import java.util.HashMap;
import java.util.Map;

public class PairGenericTest {
    public static void main(String[] args) {
        Pair<String, Integer> pair = new Pair<>("Hello", 1);

        System.out.println(pair.getKey());
        System.out.println(pair.getValue());
        System.out.println();

        //검색을 빠르게 할 수 있는 자료구조(HashMap, HashTable)
        Map<String, Integer> map = new HashMap<>();
        map.put("kor", 95);
        map.put("math", 99);
        map.put("eng", 90);

        System.out.println(map.get("kor"));
        System.out.println(map.get("math"));
        System.out.println(map.get("eng"));

    }
}
