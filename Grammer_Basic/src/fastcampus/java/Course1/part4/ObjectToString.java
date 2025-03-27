package fastcampus.java.Course1.part4;

import fastcampus.java.Course1.poly.Board;

public class ObjectToString {
    public static void main(String[] args) {

        Board board = new Board();
        board.setTile("게시물의 제목입니다."); // setter를 이용해 변수에 값 넣기
        System.out.println(board.getTitle()); //getter를 이용해 값 가져오기
        System.out.println(board.toString()); //tostirng()을 이용해 값 출력하기
    }
}
