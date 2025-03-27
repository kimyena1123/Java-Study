package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.AllStatic;

public class AllStaticTest {
    public static void main(String[] args) {

//        AllStatic st = new AllStatic();// 에러 발생 -> 생성자 메서드를 public이 아닌 private로 했기 때문. -> 객체생성을 못하도록 막을 수 있다

        // 이와 같이 AllStatic 클래스에 있는 모든 멤버(메소드)가 다 static 멤버라면, 굳이 객체를 생성해서 사용하기 보다는,
        // 아래 코드와 같이 클래스에 직접 접근(클래스 이름을 바로 사용)해서 사용하는게 더 바람직한 방법이다.
        // 그래서 생성자 메서드를 private으로 함으로써 객체 생성을 하지 못하도록 막는 것이다.
        // 위 방식과 같이 생성자 메서드를 public으로 하고 객체 생성해서 사용할 수도 있다. 두 가지 방법이 있지만, 아래 방식이 더 바람직하다.
        System.out.println(AllStatic.hap(10, 20));
        System.out.println(AllStatic.max(30, 20));
        System.out.println(AllStatic.min(23, 89));

        System.out.println("Math.max: " + Math.max(30, 50));
        System.out.println("Math.min: " + Math.min(40, 30));
    }
}
