package fastcampus.java.Course2.Part1.model;

//잘 설계된 VO, DTO
public class Book {
    //멤버변수, 상태정보, 속성(property)
    private String title;
    private int price;
    private String company;
    private String author;

    //default constructor
    public Book(){}

    //constructor overloading
    public Book(String title, int price, String company, String author){
        this.title = title;
        this.price = price;
        this.company = company;
        this.author = author;
    }

    //setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setPrice(int price){
        this.price = price;
    }

    public void setCompany(String company){
        this.company = company;
    }

    public void setAuthor(String author){
        this.author = author;
    }

    //getter
    public String getTitle(){
        return title;
    }

    public int getPrice(){
        return price;
    }

    public String getCompany(){
        return company;
    }

    public String getAuthor(){
        return author;
    }

    //Object안에 있는 toString()을 오버라이딩 한 것이다.
    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", price=" + price +
                ", company='" + company + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
