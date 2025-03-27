package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part1.model.Movie;

import java.util.ArrayList;
import java.util.List;

public class ArrayListGeneric {
    public static void main(String[] args) {
        List list = new ArrayList(); //Object이기 때문에, 서로 다른 타입이 들어갈 수 있다 -> 타입 에러 발생할 확률 높아짐 -> 제너릭 사용해야함
        list.add(new Movie("괴물", "봉준호", "2006", "한국"));
        list.add("Hello");

        System.out.println(list.get(0));
        System.out.println(list.get(1));

        System.out.println();

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("괴물", "봉준호", "2006", "한국"));
        movieList.add(new Movie("기생충", "봉준호", "2019", "한국"));

        for(Movie movie : movieList) {
            System.out.println(movie.toString());
        }

    }
}
