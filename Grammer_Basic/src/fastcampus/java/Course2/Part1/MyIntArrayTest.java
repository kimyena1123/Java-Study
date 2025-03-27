package fastcampus.java.Course2.Part1;

import fastcampus.java.Course2.Part1.model.IntArray;

public class MyIntArrayTest {
    public static void main(String[] args) {
        IntArray list = new IntArray();
        list.add(10);
        list.add(2);
        list.add(30);
        list.add(7);
        list.add(77);
        list.add(777);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));

        System.out.println("list size: " + list.size());

        for(int i = 0 ; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
