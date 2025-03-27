package fastcampus.java.Course1.part2;

public class BinaryTest {
    public static void main(String[] args) {
        int a = 10;
        float f = 34.6f;
        boolean b = false;
        char c = 'A';
        String s = "APPLE";

        //1. 69를 10진수, 2진수, 8진수, 16진수로 출력하시오
        int decimal = 69;
        System.out.println("decimal = " + decimal);

        int binary = 0b01000101;
        System.out.println("binary = " + binary);

        int octal = 0105;
        System.out.println("octal = " + octal);

        int hexadecimal = 0x45;
        System.out.println("hexadecimal = " + hexadecimal);
    }
}
