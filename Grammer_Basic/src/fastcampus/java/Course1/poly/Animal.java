package fastcampus.java.Course1.poly;

//추상클래스 (불완전한 클래스)
//스스로 혼자서는 동작할 수 없다. 반드시 하위 클래스, 자식클래스가 있어야 한다.
//추상클래스는 단독으로 쓸 수 없다.
//그래서 Animal animal = new Animal(); 이게 안된다 <- 객체생성할 수 없다
//그래서 불완전한 클래스는 혼자 스스로 객체 생성이 안된다. Animal animal = new Dog();은 할 수 있다
public abstract class Animal {

    //추상클래스는 메서드의 구현부가 없는 추상 메서드도 있고, 구현되어 있는 메서드도 올 수 있다
    public abstract void eat(); // 추상메서드(불완전한 메서드) : 메서드의 구현부가 없다!!

    public void move(){
        System.out.println("네발로 걸어다닌다");
    }
}
