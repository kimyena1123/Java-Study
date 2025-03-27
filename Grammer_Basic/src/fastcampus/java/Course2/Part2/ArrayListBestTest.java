package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part1.model.Book;

import java.util.ArrayList;
import java.util.List;

public class ArrayListBestTest {
    public static void main(String[] args) {
        //ArrayList에다 특정 타입(Book)만 넣고 싶다면? 제너릭
        List<Book> list = new ArrayList();

        list.add(new Book("자바", 15000, "한빛", "홍길동"));
        list.add(new Book("자바2", 25000, "한빛2", "홍길동2")); // 크기는 1인데, 잘 출력된다 -> add() 기능이 있음
        list.add(new Book("자바3", 35000, "한빛3", "홍길동3"));

        //다운캐스팅 안해도 된다. 왜? -> List도 Book 타입이기 때문~!(<Book>으로 List 타입을 Book으로 했기 때문).
        //List에 저장된 값도 Book. 들어갈 변수의 타입도 Book 이기 때문.
        Book vo = list.get(0);
        System.out.println(vo);

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Book){
                System.out.println(list.get(i)); //(Book) 생략해도 된다 -> Book에 toString() 재정의 되어 있기 때문!!
            }

        }

    }
}
