package fastcampus.java.Course1.part2;

import java.sql.SQLOutput;
import java.util.Scanner;

public class ScannerExam {
    public static void main(String[] args) {
        //도서정보 입력받기
        Scanner scan = new Scanner(System.in);

        System.out.print("title: ");
        String title = scan.nextLine();
        System.out.println("title = " + title);

        System.out.print("price: ");
        int price = scan.nextInt();
        System.out.println("price = " + price);

        scan.nextLine();

        System.out.print("company: ");
        String company = scan.nextLine();
        System.out.println("company = " + company);


        System.out.print("author: ");
        String author = scan.nextLine();
        System.out.println("author = " + author);

        System.out.print("page: ");
        int page = scan.nextInt();
        System.out.println("page = " + page);

        scan.nextLine();

        System.out.print("iSBN: ");
        String isbn = scan.nextLine();
        System.out.println("isbn = " + isbn);

        scan.close();

    }
}
