package fastcampus.java.Course2.Part2;

import java.util.ArrayList;

public class ListExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();

        //List 추가
        list.add("apple");
        list.add("banana");
        list.add("orange");
        list.add("grape");
        list.add("pineapple");
        list.add("cherry");
        list.add("watermelon");

        //List 출력
        for(String str : list){
            System.out.println(str);
        }

        //List 하나씩 출력
        System.out.println();
        System.out.println(list.get(0));
        System.out.println(list.getFirst());
        System.out.println(list.get(1));
        System.out.println(list.get(list.size() -1));
        System.out.println(list.getLast());
        System.out.println();

        //List 제거
        list.removeFirst(); //list.remove(0);
        list.removeLast();
        list.remove(list.size()-1);

        System.out.println();
        //List 출력
        for(String str : list){
            System.out.println(str);
        }
    }
}
