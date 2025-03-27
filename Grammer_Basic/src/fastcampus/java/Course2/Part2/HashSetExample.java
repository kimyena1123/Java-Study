package fastcampus.java.Course2.Part2;

import java.util.HashSet;
import java.util.Set;

public class HashSetExample {
    public static void main(String[] args) {
        //HashSet 객체생성
        Set<String> set = new HashSet<>();

        //요소 추가
        set.add("Apple");
        set.add("Banana");
        set.add("Orange");
        set.add("Pineapple");
        set.add("Cherry");
        set.add("Pineapple");
        set.add("Pineapple");

        //요소 개수 출력
        System.out.println("set size: " + set.size());
        System.out.println();

        //모든 요소 출력
        for(String fruit : set){
            System.out.println(fruit);
        }
        System.out.println();

        //요소 삭제
        set.remove("Banana");

        //요소 포함 여부 확인
        boolean contains = set.contains("Cherry");
        System.out.println("set contains cherry? " + contains);
        System.out.println();

        //set 비우기
        set.clear();

        //비어있는 Set 확인
        boolean empty = set.isEmpty();
        System.out.println("set isEmpty? " + empty);
    }
}
