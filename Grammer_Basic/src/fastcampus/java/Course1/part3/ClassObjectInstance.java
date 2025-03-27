package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.Student;

public class ClassObjectInstance {
    public static void main(String[] args) {

        Student st1; // st1 : object
        Student st2; // st2 : object
        Student st3; // st3 : object

        st1 = new Student("홍길동", "컴공", 25, "email@gmail.com", 2023110, "010-1111-1111"); // st1 : instance
        st2 = new Student("나길동", "전기", 25, "email@gmail.com", 2023111, "010-2222-2222"); // st2 : instance
        st3 = new Student("초길동", "사학", 25, "email@gmail.com", 2023112, "010-3333-3333"); // st3 : instance

        System.out.println(st1.toString());
        System.out.println(st2.toString());
        System.out.println(st3.toString());
    }
}
