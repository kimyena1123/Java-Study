package fastcampus.java.Course1.part2;

import java.util.Scanner;

public class IfbasicTest {
    public static void main(String[] args) {
        //정수 1개를 입력받아 입려된 수가 7의 배수인지를 출력하시오
        Scanner scan = new Scanner(System.in);

        System.out.print("정수 1개를 입력하시오: ");
        int num = scan.nextInt();
        System.out.printf("입력한 정수는 %d입니다.\n", num);

        if(num % 7 == 0){
            System.out.println("7의 배수입니다");
        }else{
            System.out.println("7의 배수가 아닙니다");
        }
    }
}
