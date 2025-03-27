package fastcampus.java.Course1.part2;// 자바는 객체지향 프로그래밍이기 때문에, 클래스 단위로 코딩을 한다\
// 시작, 메인 클래스
// JavaSE 프로그램

public class Calculator {
    public static void main(String[] args) {
        // 두 개의 정수를 더하여 출력하는 자바 프로그램을 만들어보자
        /*
            자바
                char: 2 Byte
                byte: 1 Byte = 8 bit
                short: 2 Byte
                int: 4 Byte
                long: 8 Byte
                float: 4 Byte
                double: 8 Byte
                boolean: 1 Byte
         */

        int a, b, sum;
        a = 1;
        b = 1;
        sum = a + b;
        System.out.println(sum);
    }
}
