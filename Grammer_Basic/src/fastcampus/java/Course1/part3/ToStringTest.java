package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.PersonVO;

public class ToStringTest {
    public static void main(String[] args) {

        PersonVO personVO = new PersonVO("홍길동", 22, "010-1111-1111");

        System.out.println(personVO.getName() + "\t" + personVO.getAge() + "\t" + personVO.getPhone());
        System.out.println(personVO.toString());
        System.out.println(personVO); //toString을 생략해도 된다
    }
}
