package fastcampus.java.Course2.Part2;

import java.util.ArrayList;

public class CollectionBasic {
    public static void main(String[] args) {
        //ArrayList에 10,20,30,40,50 5개의 정수(int)를 저장하고 출력하시오
        //ArrayList에는 -> Object[] 배열(클래스)이 들어가 있다. ArrayList 배열에 int형 자료형을 넣을 수 X
        //그래서 Integer로 넣어야 한다. wrapper 클래스 이용해야 한다
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(10); //원래는 list.add(new Integer(10));인데, Auto-boxing을 해서 list.add(10)으로 한다
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);
        for(int data : list){ //Auto-unboxing
            System.out.println(data);
        }

    }
}
