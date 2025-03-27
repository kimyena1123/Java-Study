package fastcampus.java.Course2.Part1;

import fastcampus.java.Course2.Part1.model.A;
import fastcampus.java.Course2.Part1.model.B;
import fastcampus.java.Course2.Part1.model.C;
import fastcampus.java.Course2.Part1.model.ObjectArray;

public class MyObjectArrayTest {
    public static void main(String[] args) {
        ObjectArray list = new ObjectArray();
        ObjectArray list2 = new ObjectArray(12);

        System.out.println("list length(배열 크기): " + list.length());
        System.out.println("list2 length(배열 크기): " + list2.length());


        list.add(new A()); // Upcasting -> Object element = new A();
        list.add(new B()); // Upcasting -> Object element = new B();
        list.add(new C()); // Upcasting -> Object element = new C();

        System.out.println();
        System.out.println("list size(배열 안에 원소 개수): " + list.size());
        System.out.println("list2 size(배열 안에 원소 개수): " + list2.size());
        System.out.println();

//        A a = list.get(0); // 에러 -> 현재 Object 타입인데(list.get(0)은 Object 타입임), 이걸 A 타입(자식)에 넣으려고 함)-> 다운캐스팅 해야 함
        A a = (A) list.get(0); //Downcasting
        a.display();

        B b = (B) list.get(1); //Downcasting
        b.display();

        C c = (C) list.get(2); //Downcasting
        c.display();

        System.out.println();
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) instanceof A) {
                ((A)list.get(i)).display();
            }else if(list.get(i) instanceof B){
                ((B)list.get(i)).display();
            }else{
                ((C)list.get(i)).display();
            }
        }
    }
}
