package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.MathOperation;

public class FunctionIntefacTest2 {
    public static void main(String[] args) {
        MathOperation mo = new MathOperationImpl();
        int result = mo.operation(10, 20);
        System.out.println(result);
    }
}
