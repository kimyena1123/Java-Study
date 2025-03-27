package fastcampus.java.Course2.Part2;

import fastcampus.java.Course2.Part1.model.Book;

import java.util.ArrayList;

public class ArrayListTest {
    public static void main(String[] args) {
        //Book 3권을 배열에 저장하고 출력하시오
        //Book[], Object[], ArrayList
        ArrayList list = new ArrayList(1); // 기본크기는 10이다. ArrayList도 내부에 Object[]을 가지고 있다.
//        List list2 = new ArrayList(1); //이렇게 써도 됨. List가 ArrayList의 부모임.


        list.add(new Book("자바", 15000, "한빛", "홍길동"));
        list.add(new Book("자바2", 25000, "한빛2", "홍길동2")); // 크기는 1인데, 잘 출력된다 -> add() 기능이 있음
        list.add(new Book("자바3", 35000, "한빛3", "홍길동3"));
        list.add(111);

//        Book vo = list.get(0); //에러 발생. 다운캐스팅 해야 함
        Book vo = (Book)list.get(0); //Object 타입이 Book 타입으로 들어가야 한다(Book <--- (Book)Object)
        System.out.println(vo);

        System.out.println(list.get(1));
        System.out.println(list.get(2));
        System.out.println(list.get(3));
        System.out.println();

        System.out.println("list size: " + list.size());

        for(int i = 0; i < list.size(); i++){
            if(list.get(i) instanceof Book){
                Book book = (Book)list.get(i);
                System.out.println(book); //(Book) 생략해도 된다 -> Book에 toString() 재정의 되어 있기 때문!!
//                System.out.println(list.get(i)); //(Book) 생략해도 된다 -> Book에 toString() 재정의 되어 있기 때문!!

            }

            if(list.get(i) instanceof Integer){
                System.out.println(list.get(i));
            }
        }
    }
}
