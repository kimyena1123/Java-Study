package fastcampus.java.Course1.part2;

public class BinaryExam {
    public static void main(String[] args) {

        int data = 123;

        // 123을 2진수로 표현
        String binary = Integer.toBinaryString(data);
        System.out.println("binary: " + binary);
        System.out.println("binary: " + binary.getClass().getSimpleName()); // 해당 객체의 타입을 반환해주는 메서드다.

        // 123을 8진수로 표현
        String octal = Integer.toOctalString(data);
        System.out.println("octal: " + octal);

        // 123을 16진수로 표현
        String hexadecimal = Integer.toHexString(data);
        System.out.println("hexadecimal: " + hexadecimal);

        int x = 123;
        System.out.println("x: " + x);

        int y = 0b1111011;
        System.out.println("y: " + y);

        int z = 0173;
        System.out.println("z: " + z);

        int u = 0x7B;
        System.out.println("u: " + u);
    }
}
