package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.PersonVO;

public class ConstructorInit {
    public static void main(String[] args) {
        // 생성자 메서드를 통해 PersonVO 객체에 이름, 나이, 전화번호를 저장하고 출력하시오
        PersonVO personVo = new PersonVO();
        System.out.println(personVo.getName() + "\t" + personVo.getAge() + "\t" + personVo.getPhone());

        PersonVO personVo2 = new PersonVO();
        System.out.println(personVo2.getName() + "\t" + personVo2.getAge() + "\t" + personVo2.getPhone());

        //개발자가 원하는 값으로 초기화하는 방법?
    }
}
