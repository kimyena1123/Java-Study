package fastcampus.java.Course1.part2;

public class CastingTest {
    public static void main(String[] args) {

        float f1 = .10f; // 0.1
        System.out.println("f1: " + f1);

        float f2 = 15f; //15.0
        System.out.println("f2: " + f2);

        float f3 = 3.14f; //3.14
        System.out.println("f3: " + f3);

        double d1 = 123.4567;
        System.out.println("d1: " + d1);

        //float -> int;
        float x = 15.6f;
        int y = (int) x;
        System.out.println("y: " + y); //15 <- 강제형변환(손실발생)

        //char -> int
        char c = 'A';
        int cc = c;
        System.out.println("cc: " + cc); //65 <- 자동형번환

        //int -> double
        int dd = 5;
        double ddd = dd;
        System.out.println("ddd: " + ddd); //5.0 <- 자동형변환

        //double -> int
        double dx = 14.67;
        int dy = (int)dx;
        System.out.println("dy: " + dy); //14 <- 강제형변환
    }
}
