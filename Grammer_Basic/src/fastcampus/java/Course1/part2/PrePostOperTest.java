package fastcampus.java.Course1.part2;

public class PrePostOperTest {
    public static void main(String[] args) {

        int x = 10;

        System.out.println(--x); //9
        System.out.println(x--); //9
        System.out.println(x); //8

        System.out.println(++x); //9
        System.out.println(x++); //9
        System.out.println(x); // 10

        --x;
        System.out.println(x); // 9
        x--;
        System.out.println(x); // 8
    }
}
