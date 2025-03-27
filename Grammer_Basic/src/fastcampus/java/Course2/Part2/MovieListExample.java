package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part1.model.Movie;

import java.util.ArrayList;

public class MovieListExample {
    public static void main(String[] args) {
        ArrayList<Movie> movieList = new ArrayList<>();

        //movieList add
        movieList.add(new Movie("괴물", "봉준호", "2006", "한국"));
        movieList.add(new Movie("기생충", "봉준호", "2019", "한국"));
        movieList.add(new Movie("완벽한 타인", "이재규", "2018", "한국"));
        movieList.add(new Movie("완벽한 타인", "이재규", "2018", "한국"));


        for(Movie movie : movieList) {
            System.out.println(movie); // movie.toString() 과 같은 코드
        }

        for(Movie movie : movieList) {
            System.out.printf("|%-16s|%-5s|%-9s|%-6s\n", movie.getTitle(), movie.getDirector(), movie.getYear(), movie.getCountry());
        }
        System.out.println();

        String searchTitle = "기생충";

        //순차검색 -> 이진 검색(중요)
        for(Movie movie : movieList) {
            if(movie.getTitle().equals(searchTitle)){
                System.out.println(movie);
                break;
            }
        }
    }
}
