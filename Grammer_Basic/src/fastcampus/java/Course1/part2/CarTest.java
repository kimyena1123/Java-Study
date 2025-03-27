package fastcampus.java.Course1.part2;

public class CarTest {
    public static void main(String[] args) {

        // 자동차의 정보를 저장하려고 한다. 변수를 만들어 보시오
        String model = "BMW528i"; // 이 String은 External Libraries에 있다. 자바에서 제공하는 것임!
        long distance = 1000000;
        int price = 9000000;
        String company = "BMW";
        char type = 'A';
        boolean auto = true;
        int year = 2000;
        float gasmi = 12.5f;

        System.out.println("model = " + model);
        System.out.println("distance = " + distance + "km");
        System.out.println("price = " + price);
        System.out.println("company = " + company);
        System.out.println("type = " + type + "type");
        System.out.println("auto = " + auto);
        System.out.println("year = " + year);
        System.out.println("gasmi = " + gasmi + "l");
    }
}
