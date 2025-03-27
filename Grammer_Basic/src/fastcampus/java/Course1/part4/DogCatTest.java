package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.part4.model.Cat;
import fastcampus.java.Course1.part4.model.Dog;

public class DogCatTest {
    public static void main(String[] args) {

        //Dog 객체를 생성하고 eat() 동작을 구동해보자
        Dog dog = new Dog();
        dog.eat();

        //Cat 객체를 생성하고 eat() 동작과 night() 동작을 구동해보자
        Cat cat = new Cat();
        cat.eat();
        cat.night();
    }
}
