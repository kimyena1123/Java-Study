package kr.book.search;

public class Book {
    private String title;
    private String authors;
    private String publisher;
    private String thumbnail;

    public Book(){}

    public Book(String title, String authors, String pulisher, String thumbnail) {
        this.title = title;
        this.authors = authors;
        this.publisher = pulisher;
        this.thumbnail = thumbnail;
    }

    //setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public void setPulisher(String pulisher) {
        this.publisher = pulisher;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    //getter
    public String getTitle() {
        return title;
    }

    public String getAuthors() {
        return authors;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", authors='" + authors + '\'' +
                ", pulisher='" + publisher + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                '}';
    }
}
