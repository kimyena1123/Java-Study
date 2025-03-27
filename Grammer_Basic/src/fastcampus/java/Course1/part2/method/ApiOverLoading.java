package fastcampus.java.Course1.part2.method;

public class ApiOverLoading {
    public static void main(String[] args) {
        //메서드 오버로딩(Overloading)
        System.out.println(10);
        System.out.println(10.4f);
        System.out.println('A');
        System.out.println("APPLE");
        //위 println()들이 오버로딩이다. 함수명은 같고, 매개변수만 다르게.

        int max = maxValue(7, 9);
        System.out.println("max : " + max);

        int min = minValue(3, 8);
        System.out.println("min : " + min);

    }

    //사용자 정의 메서드
    //두 개의 정수를 매개변수로 받아서 더 큰 수를 리턴하는 메서드를 정의하시오
    public static int maxValue(int a, int b){
        return (a > b) ? a : b; //return Math.max(a, b);
    }

    //두 개의 정수를 매개변수로 받아서 더 작은 수를 리턴하는 메서드를 정의하시오
    public static int minValue(int a, int b){
        return (a < b) ? a : b; //return Math.min(a, b);
    }

}
