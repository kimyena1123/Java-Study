package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.part4.model.Animal;
import fastcampus.java.Course1.part4.model.Cat;
import fastcampus.java.Course1.part4.model.Dog;

public class PolyMethodTest {
    public static void main(String[] args) {

        Dog d = new Dog();
        display(d);

        Cat c = new Cat();
        display(c);
    }

    //오버로딩 : 메소드 이름은 같지만, 타입은 다름
//    public static void display(Dog d) {
//        d.eat();
//    }
//
//    public static void display(Cat c) {
//        c.eat();
//        c.night();
//    }

    public static void display(Animal animal) { // 다형성 인수
        animal.eat();
//        animal.night(); // 에러 발생 -> 왜? Cat에만 있는 고유한 메서드이기 때문 -> 다운캐스팅 해야 함
//        ((Cat)animal).night(); // 에러 발생 -> 왜? 이 명령문은 Cat일 때만 실행해야 한다 Dog일때는 실행하먄 x. -> Cat 타입으로 받은 경우에만 실행해야 한다

        if(animal instanceof Cat){ // instanceof로 타입검사 -> 결과는  true, false로 나옴
            ((Cat)animal).night();
        }
    }
}


