package fastcampus.java.Course1.part3;

public class PersonAccessTest {
    public static void main(String[] args) {
        //Person 클래스에 이름, 나이, 전화번호를 저장하고 출력하시오
        Person person = new Person();

        person.name = "홍길동A";
        person.age = 1000;
        person.phone = "010-1111-1111";
        System.out.println(person.name + "\t" + person.age + "\t" + person.phone);
    }
}
