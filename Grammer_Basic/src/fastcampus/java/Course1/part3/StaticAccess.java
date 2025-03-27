package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.MyUtil;

public class StaticAccess {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;


        //MyUtil 클래스에 static이 있는 메서드 사용
        int result1 = MyUtil.hap1(a, b);
        System.out.println("타 클래스에 static이 있는 메서드 사용: " + result1);


        //MyTuil 클래스에 static이 없는 메서드 사용 -> new로 객체를 생성해서 접근
        MyUtil mtil = new MyUtil();
        int result2 = mtil.hap2(a, b);
        System.out.println("타 클래스에 static이 없는 메서드 사용: " + result2);

    }
}

