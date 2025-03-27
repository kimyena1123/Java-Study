package fastcampus.java.Course1.part2.method;

import java.util.Scanner;

public class Overloading {
    public static void main(String[] args) {
        // 매개변수로 두 개의 정수 값을 받아서 총합을 구하여 리턴하는 메서드를 정의하시오
        // 매개변수로 두 개의 실수 값을 받아서 총합을 구하여 리턴하는 메서드를 정의하시오
        Scanner scan = new Scanner(System.in);
        System.out.print("두 개의 정수: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        int resultInt = add(num1, num2);

        System.out.println("정수 총합: " + resultInt);

        System.out.print("두 개의 실수: ");
        float num3 = scan.nextFloat();
        float num4 = scan.nextFloat();
        float resultFloat = add(num3, num4);
        System.out.println("실수 총합: " + resultFloat);

    }

    public static int add(int a, int b){
        return a + b;
    }

    public static float add(float a, float b){

        return a + b;
    }
}
