package fastcampus.java.Course1.part2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("문자열을 입력하세요: ");
        String str = scanner.next();
        System.out.println("str = " + str);

        scanner.nextLine(); // 버퍼 비우기(스트림 비우기) <- 안하면 원하는 대로 작동X

        System.out.print("문자열을 입력하세요: ");
        String string = scanner.nextLine();
        System.out.println("str = " + string);

        scanner.close(); // 연결 끊기

    }
}

