package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part1.model.Book;
import fastcampus.java.Course2.Part1.model.Movie;
import fastcampus.java.Course2.Part2.model.ObjectArray;

public class GenericTest {
    public static void main(String[] args) {
        ObjectArray<String> array = new ObjectArray<>(5);
        array.set(0, "hello");
        array.set(1, "world");
        array.set(2, "java");
        array.set(3, "generic");
        array.set(4, "exmaple");

        for(int i = 0; i < array.size(); i++){
            System.out.println(array.get(i));
        }

        System.out.println();

        ObjectArray<Integer> array2 = new ObjectArray<>(3);
        array2.set(0, 1);
        array2.set(1, 2);

        for(int i = 0; i < array2.size(); i++){
            System.out.println(array2.get(i));
        }

        System.out.println("size: " + array2.size());
        System.out.println("length: " + array2.length());

        ObjectArray<Movie> array3 = new ObjectArray<>(2);
        array3.set(0, new Movie("괴물", "봉준호", "2006", "한국"));
        array3.set(1, new Movie("기생충", "봉준호", "2019", "한국"));

        for(int i = 0; i < array3.size(); i++){
            System.out.println(array3.get(i));
        }
    }
}
