package fastcampus.java.Course1.part3;

public class PersonTest {
    public static void main(String[] args) {
        //모델링된 Person 클래를 이용하여 [객체를 메모리에 생성]하시
        //인스턴스를 만드는 과정
        Person person = new Person();

        person.name="김예나";
        person.age=25;
        person.phone="010-1111-1111";
        System.out.println(person.name + "\t" + person.age + "\t" + person.phone);

        person.play();
        person.eat();
        person.walk();

        Person person2 = new Person();

        person2.name="김예나2";
        person2.age=24;
        person2.phone="010-2111-1111";
        System.out.println(person2.name + "\t" + person2.age + "\t" + person2.phone);

        person2.play();
        person2.eat();
        person2.walk();
    }
}
