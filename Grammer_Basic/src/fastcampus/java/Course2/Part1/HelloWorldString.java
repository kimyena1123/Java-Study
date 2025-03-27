package fastcampus.java.Course2.Part1;

public class HelloWorldString {
    public static void main(String[] args) {
        String str1 = new String("Hello World"); //Heap 메모리에 만들어진다
        System.out.println(str1.toString());

        String str2 = "Hello World"; // Literal Pool(재활용 가능 공간)에 만들어진다
        System.out.println(str2.toString());
    }
}
