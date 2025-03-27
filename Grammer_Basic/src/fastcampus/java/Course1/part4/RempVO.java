package fastcampus.java.Course1.part4;

public class RempVO extends Employee{

    public RempVO(){
        super(); // 상위 클래스의 생성자를 호출 -> new Employee()
    }

    //생성자 오버로딩
    public RempVO(String name, int age, String phone, String empDate, String dept, boolean marriage){
        //초기화(자식이 부모의 기억공간에 초기화를 하는 경우)
//        this.name = name;
//        this.age = age;
//        this.phone = phone;
//        this.empDate = empDate;
//        this.dept = dept;
//        this.marriage = marriage;
        super(name, age, phone, empDate, dept, marriage); // 부모의 생성자를 호출
    }
}
