package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.PersonVO;

public class ConstructorOverloading {
    public static void main(String[] args) {
        PersonVO personVO = new PersonVO();
        PersonVO personVO1 = new PersonVO("나길동", 22, "010-2222-2222");
        PersonVO personVO2 = new PersonVO("초길동", 33, "010-3333-3333");

        personVO.setName("예시1");
        personVO.setAge(11);
        personVO.setPhone("010-0000-0000");

        System.out.println(personVO.getName() + "\t" + personVO.getAge() + "\t" + personVO.getPhone());
        System.out.println(personVO1.getName() + "\t" + personVO1.getAge() + "\t" + personVO1.getPhone());
        System.out.println(personVO2.getName() + "\t" + personVO2.getAge() + "\t" + personVO2.getPhone());
    }
}
