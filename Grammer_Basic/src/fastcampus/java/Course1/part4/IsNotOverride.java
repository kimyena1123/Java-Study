package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.poly.Animal;
import fastcampus.java.Course1.poly.Cat;
import fastcampus.java.Course1.poly.Dog;

public class IsNotOverride {
    public static void main(String[] args) {

        //재정의를 안했기 때문에 -> 부모가 명령을 내리면(메시지를 보내면) 오동작을 한다
        //다형성을 보장하지 않음 -> 그러면 다형성을 보장하려면? -> 재정의를 "강제로" 하도록 만들어주면 된다
        //추상클래스, 인터페이스 등장
        //[다형성이 보장이 된다]
        Dog dog = new Dog();
        Cat cat = new Cat();

        dog.eat();
        cat.eat();

        //츠상클래스는 부모의 역할을 할 수 있다
        Animal animalDog = new Dog();
        Animal animalCat = new Cat();

        animalDog.move();
        animalCat.move();
    }
}
