package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.MathOperation;

public class FunctionInterfaceTest3 {
    public static void main(String[] args) {
        //MathOperation 인터페이스를 내부 익명 클래스로 구현해보자
        MathOperation mo = new MathOperation(){ // 익명 내부 클래스

            @Override
            public int operation(int x, int y) {
                return x + y;
            }
        };

        int result = mo.operation(10,20);
        System.out.println(result);
    }
}
