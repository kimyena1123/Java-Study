package fastcampus.java.Course1.model;

public class PersonVO {
    //상태정보는 보통 private.
    private String name;
    private int age;
    private String phone;

    //보이진 않지만, 생략된 생성자 메서드가 있다. => 기본 생성자(Default Constructor)
    public PersonVO(){
        //객체를 생성하는 코드는 내부에서 만들어진다.
//        this.name = "홍길동";
//        this.age = 20;
//        this.phone = "010-1111-1111";
    }

    //생성자 메서드 오버로딩(Overloåding)
    public PersonVO(String name, int age, String phone){
        this.name = name;
        this.age = age;
        this.phone = phone;
    }


    //setter
    public void setName(String name){
        this.name = name;
    }

    public void setAge(int age){
        this.age = age;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    //getter
    public String getName(){
        return this.name;
    }

    public int getAge(){
        return age; //this.age
    }

    public String getPhone(){
        return phone; //this.phone
    }

    public String toString(){
        return name + "\t" + age + "\t" + phone;
    }
}
