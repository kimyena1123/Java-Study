package fastcampus.java.Course1.part2.method;

import java.util.Scanner;

public class MethodMakeTest {
    public static void main(String[] args) {

        //매개변수로 2개의 정수를 받아서 총합을 구하여 리턴하는 메서드를 정의하시오
        Scanner scan = new Scanner(System.in);
        System.out.print("두 개의 정수를 입력하시오: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();

        int sum = add(num1, num2);
        System.out.println("두 수의 총합: " + sum);
    }

    //이 메서드에 static이 붙은 이유: 이 함수를 호출하는 곳(main 메서드 안)이 static으로 되어 있다. -> public static void main으로 되어 있다
    // -> static에서 메서드를 호출했으면, 해당 메서드도 static으로 되어 있어야 한다.
    // 메서드를 static으로 안할거면 객체를 생성해야 한다 -> 어떤 객체? MethodMakeTest 객체를 생성한 후 해야 한다
    public static int add(int num1, int num2) {
        return num1 + num2;
    }
}
