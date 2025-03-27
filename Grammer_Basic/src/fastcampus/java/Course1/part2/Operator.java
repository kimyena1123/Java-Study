package fastcampus.java.Course1.part2;

public class Operator {
    public static void main(String[] args) {
        // 두 과목의 점수를 이용하여 총점과 평균을 출력하는 JavaSE 프로그램을 만들어보자
        int kor, eng; // 변수 선언 -> 기억공간이 만들어진다.
        kor = 77;
        eng = 87;
        int sum = kor + eng;
        int avg = sum / 2;

        System.out.println("총점: " + sum);
        System.out.println("평균: " + avg);
    }
}
