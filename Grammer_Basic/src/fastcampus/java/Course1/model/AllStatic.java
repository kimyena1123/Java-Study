package fastcampus.java.Course1.model;

public class AllStatic {

    //생성자 메서드
    private AllStatic(){

    }

    public static int hap(int a, int b){
        int sum = a + b;
        return sum;
    }

    public static int max(int a, int b){
        return a > b ? a : b;
    }

    public static int min(int a, int b){
        return a < b ? a : b;
    }
}
