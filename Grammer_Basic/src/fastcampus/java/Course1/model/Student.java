package fastcampus.java.Course1.model;

public class Student {
    private String name;
    private String dept;
    private int age;
    private String email;
    private int year;
    private String phone;

    //default constructor
    public Student(){

    }

    // constructor overloading
    public Student(String name, String dept, int age, String email, int year, String phone) {
        this.name = name;
        this.dept = dept;
        this.age = age;
        this.email = email;
        this.year = year;
        this.phone = phone;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    //getter

    public String getName() {
        return name;
    }

    public String getDept() {
        return dept;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public int getYear() {
        return year;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", year=" + year +
                ", phone='" + phone + '\'' +
                '}';
    }
}
