package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.part4.model.Animal;
import fastcampus.java.Course1.part4.model.Cat;
import fastcampus.java.Course1.part4.model.Dog;

public class OverrideTest {
    public static void main(String[] args) {

        Animal animal = new Dog();
        animal.eat();

        animal = new Cat();
        animal.eat();
    }
}
