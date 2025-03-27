package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.part3.Person;
import fastcampus.java.Course1.poly.Radio;
import fastcampus.java.Course1.poly.RemoCon;
import fastcampus.java.Course1.poly.Tv;

public class InterfaceTest {
    public static void main(String[] args) {
        RemoCon remoCon1 = new Tv();
        RemoCon remoCon2 = new Radio();

        //다형성이 100% 보장이 된다
        //부모가 인터페이스이면 자식의 내부 동작방식을 전혀 몰라도 동작시킬 수 있다
        //RemoCon remo = new RemoCon(); 객체생성 불가하다
        //부모의 역할을 할 수 있다
        System.out.println("======== TV ========");
        remoCon1.chUp();
        remoCon1.chDown();
        remoCon1.volUp();
        remoCon1.volDown();
        remoCon1.internet();

        System.out.println("\n======== Radio ========");
        remoCon2.chUp();
        remoCon2.chDown();
        remoCon2.volUp();
        remoCon2.volDown();
        remoCon2.internet();

    }
}
