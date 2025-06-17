package org.delivery.ex01;

public class Exam01 {

    //생성자 메서드
    public Exam01(){

        /** [코드작성]
         * 기본적으로 여기가 static이기 때문에 변수를 선언한다고 하면,
         * public static or static으로 다 선언해줘야 한다.
         * 그래서 아래에 main만 하위에서 호출을 하도록 할 것이다.
         */

        //===================== 변수선언 =====================
        //자바에는 primitive 타입과 reference 타입이 있다

        String name = "김예나";
        String format = "사용자의 이름은 : %s";
        String result = String.format(format, name);

        int age = 10;       //primitive 타입; 기본값은 0이다.
        Integer _age = 20;  //reference 타입; 기본값은 null이다.

        double d = 10d;
        Double _d = 20.0;

        float f = 20f;
        Float _f = 20f;

        long l = 10L;
        Long _l = 10L;

        boolean bool = true;
        Boolean _bool = true;

        //===================== 출력 =====================
        System.out.println(name);
        System.out.println("사용자의 이름은: " + name);
        System.out.println(result);

        System.out.println(age);
        System.out.println(_age);
        System.out.println(d);
        System.out.println(_d);
        System.out.println(f);
        System.out.println(_f);
        System.out.println(l);
        System.out.println(_l);
        System.out.println(bool);
        System.out.println(_bool);
    }

    public static void main(String[] args) {

        new Exam01();
    }
}
