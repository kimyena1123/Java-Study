package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.poly.A;
import fastcampus.java.Course1.poly.B;

public class ObjectPolyTest {
    public static void main(String[] args) {
        A a = new A();
        display(a);

        B b = new B();
        display(b);
    }

    public static void display(Object obj){
        if(obj instanceof A){
            ((A)obj).printGo();
        }else{
            ((B)obj).printGo();
        }
    }
}
