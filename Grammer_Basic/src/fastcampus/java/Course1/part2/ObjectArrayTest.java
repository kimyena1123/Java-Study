package fastcampus.java.Course1.part2;

public class ObjectArrayTest {
    public static void main(String[] args) {

        Book b1, b2, b3 = new Book(); // 이건 배열을 만든 게 아니다. 그냥 객체 3개를 개별로 만든거다.

        // 객체 배열
        Book[] book = new Book[3]; // 책 3권을 저장할 배열 생성
        book[0] = new Book();

        book[0].title = "책1";
        book[0].price = 10000;
        book[0].company = "회사1";
        book[0].author = "이름1";
        book[0].page = 500;
        book[0].isbn = "11889900";

        book[1] = new Book();
        book[1].title = "책2";
        book[1].price = 20000;
        book[1].company = "회사2";
        book[1].author = "이름2";
        book[1].page = 600;
        book[1].isbn = "22889900";

        book[2] = new Book();
        book[2].title = "책3";
        book[2].price = 30000;
        book[2].company = "회사3";
        book[2].author = "이름3";
        book[2].page = 700;
        book[2].isbn = "33889900";

        System.out.println(book[0].title + "\t" + book[0].price + "\t" + book[0].company + "\t" + book[0].author + "\t" + book[0].page);
        System.out.println(book[1].title + "\t" + book[1].price + "\t" + book[1].company + "\t" + book[1].author + "\t" + book[1].page);
        System.out.println(book[2].title + "\t" + book[2].price + "\t" + book[2].company + "\t" + book[2].author + "\t" + book[2].page);

        System.out.println("------ for문으로 출력 -------");
        for(int i =0; i < book.length; i++){
            System.out.println(book[i].title + "\t" + book[i].price + "\t" + book[i].company + "\t" + book[i].author + "\t" + book[i].page);
        }

    }
}
