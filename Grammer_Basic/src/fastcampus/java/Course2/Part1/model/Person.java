package fastcampus.java.Course2.Part1.model;

public class Person extends Object{
    private String name;
    private int age;


    //기본 생성자(default constructor)
    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    //setter
    public void setName(String name) {
        this.name = name;
    }
    public void setAge(int age) {
        this.age = age;
    }

    //getter
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
