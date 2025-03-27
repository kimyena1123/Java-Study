package fastcampus.java.Course1.model;

public class MemberDTO {

    //상태정보 = 멤벼변수 = 프로퍼티
    public String name;
    private int age;  //정보은닉
    public String phone;

    public void play(){
        System.out.println("운동을 한다");
    }

    public void walk(){
        System.out.println("산책을 한다");
    }



}
