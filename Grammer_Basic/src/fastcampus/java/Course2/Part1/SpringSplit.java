package fastcampus.java.Course2.Part1;

import java.util.Scanner;

public class SpringSplit {
    public static void main(String[] args) {
        String str = "Hello,World,Java";

        //쉼표를 구분자로 사용하여 문자열을 분리한다
        String[] array = str.split(",");

        for(String content: array){
            System.out.println(content);
        }

        System.out.println();

        //정규표현식을 사용하여 공백을 구분자로 사용한다
        str = "Hello2 World2 Java2";
        String[] array2 = str.split("\\s+"); //정규표현식 \s+은 하나 이상의 공백 문자(whitespace character)를 나타내는 표현식

        for(String content: array2){
            System.out.println(content);
        }

        Scanner scan = new Scanner(System.in);
        System.out.print("문자열을 입력하세요: ");
        String inputScan = scan.nextLine();
        String[] array3 = inputScan.split("\\s+");

        for(String content: array3){
            System.out.println(content);
        }
    }
}
