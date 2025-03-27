package fastcampus.java.Course1.part2;

public class ArrayExam {
    public static void main(String[] args) {
        char[] c = {'A', 'P', 'P', 'L', 'E'};

        //대문자로 된 APPLE을 소문자 apple로 출력하시오
        for(int i = 0; i < c.length; i++) {
            c[i] = (char)(c[i] + 32);
            System.out.print(c[i]);
        }

    }
}
