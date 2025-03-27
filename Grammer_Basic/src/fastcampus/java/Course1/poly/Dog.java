package fastcampus.java.Course1.poly;

public class Dog extends Animal {

    //재정의(Overloading)를 하지 않음
    //부모 클래스를 abstract로 했으면, 무조건 오버로딩(재정의)가 있어야 한다. 안그럼 에러 발생.
    //부모 클래스가 원래 일반 클래스였다가 추상클래스로 변경됨(메서드의 구현부가 없는 메서드 존재)
    // -> 자식클래스에서 재정의를 하지 않으면, 구현이 안되어 있는 메서드를 사용하는 것이기 때문에, 재정의(오버로딩)를 해야 한다

    @Override
    public void eat() {
        System.out.println("개처럼 먹다");
    }
}
