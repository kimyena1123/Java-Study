package fastcampus.java.Course1.part2;

public class BookExam {
    public static void main(String[] args) {
        // [정수] 한 개를 저장할 [변수를 선언] 하시오
        int a;
        a = 10;


        // 한 권의 책 데이터를 저장하기 위해서 객체를 생성하시오(인스턴스를 만드시오)
        Book book = new Book();
        book.title = "자바";
        book.price=30000;
        book.company = "fastcampus";
        book.author = "김예나";
        book.page = 200;
        book.isbn = "1199110";

        System.out.println(book.title + '\t' + book.author + '\t' + book.page + '\t' + book.company + '\t' + book.isbn);

    }
}
