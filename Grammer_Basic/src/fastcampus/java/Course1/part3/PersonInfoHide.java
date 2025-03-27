package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.PersonVO;

public class PersonInfoHide {
    public static void main(String[] args) {
        //한 사람의 회원 정보를 저장할 객체를 생성
        PersonVO personVO = new PersonVO();

        //에러발생
        /*
        personVO.name = "홍길동";
        personVO.age = 55000; //정보 은닉이 되지 않음
        personVO.phone = "010-2222-2222";
         */


        //setter,getter 사용해서 값 넣고 출력하기
        personVO.setName("홍길동");
        personVO.setAge(18);
        personVO.setPhone("010-1111-2222");

        System.out.println(personVO.getName() + "\t" + personVO.getAge() + "\t" + personVO.getPhone());
    }
}
