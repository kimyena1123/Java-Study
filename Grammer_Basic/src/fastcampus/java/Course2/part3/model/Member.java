package fastcampus.java.Course2.part3.model;

public class Member {
    private String name;
    private int age;
    private String email;

    public Member(){};

    public Member(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    //getter
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                '}';
    }

}
