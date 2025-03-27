package fastcampus.java.Course2.Part1;

import fastcampus.java.Course2.Part1.model.Book;
import fastcampus.java.Course2.Part1.model.BookArray;

public class MyBookArrayTest {
    public static void main(String[] args) {
        BookArray list = new BookArray();
        list.add(new Book("자바", 15000, "한빛", "홍길동"));
        list.add(new Book("자바2", 25000, "한빛2", "홍길동2"));
        list.add(new Book("자바3", 35000, "한빛3", "홍길동3"));
        list.add(new Book("자바4", 45000, "한빛4", "홍길동4"));


        Book vo = list.get(0);
        System.out.println(vo); // vo.toString()이 호출된다

        System.out.println(list.get(1));

        System.out.println(list.get(2));

        System.out.println("size: " + list.size());

        System.out.println();
        for(int i = 0; i < list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
