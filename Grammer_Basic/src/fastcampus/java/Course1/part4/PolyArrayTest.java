package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.part4.model.Animal;
import fastcampus.java.Course1.part4.model.Cat;
import fastcampus.java.Course1.part4.model.Dog;

public class PolyArrayTest {
    public static void main(String[] args) {

        Dog dog = new Dog();
        Cat cat = new Cat();

        Animal[] animal = new Animal[2];
//        Animal[] animal2 = {new Dog(), new Cat()};
        animal[0] = dog;
        animal[1] = cat;

        display(animal);

    }

    public static void display(Animal[] animal) {

        System.out.println("-----출력 1-----");
        for(Animal a : animal){
            a.eat();
            if(a instanceof Cat){
                ((Cat)a).night();
            }
        }

        System.out.println("-----출력 2-----");
        for(int i = 0; i < animal.length; i++){
            animal[i].eat();

            if(animal[i] instanceof Cat){
                ((Cat)animal[i]).night();
            }
        }
    }
}
