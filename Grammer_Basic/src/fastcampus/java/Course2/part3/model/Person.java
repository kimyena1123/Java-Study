package fastcampus.java.Course2.part3.model;

public class Person {
    private String name;
    private int age;
    private String email;
    private Address address;

    public Person(){};

    public Person(String name, int age, String email, Address address) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.address = address;
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

    public void setAddress(Address address) {
        this.address = address;
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

    public Address getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address=" + address +
                '}';
    }
}
