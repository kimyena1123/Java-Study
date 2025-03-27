package fastcampus.java.Course2.Part1;

public class IntegerToString {
    public static void main(String[] args) {
        String value = "1234";
        int num = Integer.parseInt(value);
        System.out.println(num + 1000);

        int number = 111;
        String str = String.valueOf(number);
        System.out.println(str + 11);

        String str2 = "" + number;
        System.out.println(str2 + 10);
    }
}
