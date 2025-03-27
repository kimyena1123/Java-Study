package fastcampus.java.Course1.part2;

import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        //년도를 입력받아서 해당 년도가 윤년인지 아닌지를 판단하여 출력하는 코드를 작성하시오
        //윤년: 2월 29일이 존재하는 년도
        //4의 배수이면서 100의 배수가 아닌 해이거나 400의 배수인 해

        Scanner scan = new Scanner(System.in);

        System.out.print("년도를 입력하시오: ");
        int year = scan.nextInt();
        System.out.printf("입력한 년도는 %d 입니다\n", year);

        if((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
            System.out.printf("%d는 윤년입니다", year);
        }else{
            System.out.printf("%d는 윤년이 아닙니다", year);
        }
    }
}
