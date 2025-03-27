package fastcampus.java.Course1.part2;

import java.util.Scanner;

public class MaxMinValue {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("슷자 두 개를 입력하시오: ");
        int num1 = scan.nextInt();
        int num2 = scan.nextInt();
        System.out.printf("입력한 숫자는 %d %d 입니다.\n", num1, num2);

        System.out.println("num1 = " + num1);
        System.out.println("num2 = " + num2);

        int max = (num1 > num2) ? num1 : num2;
        int min = (num1 < num2) ? num1 : num2;

        System.out.printf("max = %d, min = %d\n", max, min);

    }
}
