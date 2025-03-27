package fastcampus.java.Course1.part4.model;

public class Dog extends Animal {

    public Dog(){
        super(); // new Animal();
    }

    public void eat(){
        System.out.println("개처럼 먹다");
    }
}
