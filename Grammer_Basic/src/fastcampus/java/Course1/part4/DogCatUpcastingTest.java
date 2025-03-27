package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.part4.model.Animal;
import fastcampus.java.Course1.part4.model.Cat;
import fastcampus.java.Course1.part4.model.Dog;

public class DogCatUpcastingTest {
    public static void main(String[] args) {

//        Dog dog = new Dog();
        Animal animal1 = new Dog(); //부모가 자식을 가리킨다 -> 업캐스팅
        animal1.eat(); // -> Animal의 eat이 나온다.

        Animal animal2 = new Cat();
        animal2.eat(); // -> Animal의 eat이 나온다.
    }

}
