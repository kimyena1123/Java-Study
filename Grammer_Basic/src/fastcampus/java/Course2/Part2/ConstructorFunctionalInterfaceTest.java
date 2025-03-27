package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part2.model.Person;
import fastcampus.java.Course2.Part2.model.PersonFactory;

public class ConstructorFunctionalInterfaceTest {
    public static void main(String[] args) {
        //방법1
        PersonFactory personFactory = Person::new;
        Person person = personFactory.create("홍길동", 29);
        System.out.println(person);

        //방법2
        PersonFactory personFactory2 = new PersonFactory() { // 익명내부클래스
            @Override
            public Person create(String name, int age) {
                return new Person(name, age);
            }
        };

        Person person2 = personFactory.create("나갈동", 30);
        System.out.println(person2);
    }
}
