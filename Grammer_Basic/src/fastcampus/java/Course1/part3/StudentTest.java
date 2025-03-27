package fastcampus.java.Course1.part3;

import fastcampus.java.Course1.model.Student;

import java.sql.SQLOutput;

public class StudentTest {
    public static void main(String[] args) {

        //정수 6개를 젖아할 배열 생성
        int[] arr = new int[6];
        arr[0] = 10;
        arr[1] = 30;
        arr[2] = 67;
        arr[3] = 98;
        arr[4] = 55;
        arr[5] = 32;

        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //잘 설계된 학생(Student) 객체를 설계하고 데이터를 저장한 후 출력하시오
        Student student = new Student("홍길동", "컴퓨터공학과", 25, "email@gmail.com", 202021111, "010-1111-1111");

        System.out.println(student);
        System.out.println(student.toString());

        System.out.println();

        //학생 객체 배열
        Student[] students = new Student[4];
        students[0] = new Student("초길동", "컴공", 25, "email@gmail.com", 202021111, "010-1111-1111");
        students[1] = new Student("나길동", "전기", 25, "email@gmail.com", 202022222, "010-2222-2222");
        students[2] = new Student("김길동", "건축", 25, "email@gmail.com", 202023333, "010-3333-3333");
        students[3] = new Student("이길동", "통신", 25, "email@gmail.com", 202024444, "010-4444-4444");

        for(int i = 0; i < students.length; i++) {
            System.out.println(students[i].toString());
        }
        System.out.println();

        for(Student std: students){
            System.out.println(std.toString());
        }
    }
}
