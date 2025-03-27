package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.part4.model.Animal;
import fastcampus.java.Course1.part4.model.Cat;
import fastcampus.java.Course1.part4.model.Dog;

public class ObjectCasting {
    public static void main(String[] args) {
        //Animal -->Dog, Cat
        Animal animal = new Dog(); // upcasing
        animal.eat();

        animal = new Cat(); // upcasting
        animal.eat();
//      animal.night(); --> 에러. 왜? : 업캐스팅하면 자식 클래스의 메소드나 변수를 사용할 수 없다. -> 자식의 타입을 부모로 형변환 한것임. 부모 클래스만 사용할 수 있는거다! 그래서 자식 클래스인 night 사용 X. -> 다운캐스팅하면 된다

        Cat check = (Cat) animal; //다운캐스팅 -> Cat의 night 함수 사용할 수 있음
        check.night();

        ((Cat)check).night();
    }
}
