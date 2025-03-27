package fastcampus.java.Course1.part3;

public class Person { // Object = 상태정보(멤버변수) + 행위정보(멤버 메서드)

    //상태정보 = 멤버변수 = 프로퍼티
    public String name;
    public int age;
    public String phone;

    public Person(){

    }

    //행위정보 = 멤버메서드
    public void play(){
        System.out.println("운동을 한다");
    }

    public void eat(){
        System.out.println("먹다");
    }

    public void walk(){
        System.out.println("걷다");
    }
}
