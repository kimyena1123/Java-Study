package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.poly.A;
import fastcampus.java.Course1.poly.B;

public class ObjectPolyArray {
    public static void main(String[] args) {

        Object[] obj = new Object[2];
        obj[0] = new A();
        obj[1] = new B();

        display(obj);

    }
    public static void display(Object[] obj){
        for(int i = 0; i < obj.length; i++) {
            if(obj[i] instanceof A){
                ((A)obj[i]).printGo();
            }else{
                ((B)obj[i]).printGo();
            }
        }
    }
}
