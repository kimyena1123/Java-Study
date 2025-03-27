package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.MathOperation;

public class LambdaExample {
    public static void main(String[] args) {

        //MathOperation 인터페이스를 내부 익명 클래스로 구현해보자
        MathOperation mo = new MathOperation(){ // 익명 내부 클래스

            @Override
            public int operation(int x, int y) {
                return x + y;
            }
        };

        //람다식 사용
        int result = mo.operation(10,20);
        System.out.println(result);

        System.out.println("================================");

        MathOperation mo2 = (x, y) -> x + y; // (int x, int y) -> x + y; 이렇게도 사용 가능
        MathOperation mo3= (x, y) -> x * y;

        int result2 = mo2.operation(11,22);
        System.out.println(result2);

        int result3 = mo3.operation(3, 7);
        System.out.println(result3);
    }

}
