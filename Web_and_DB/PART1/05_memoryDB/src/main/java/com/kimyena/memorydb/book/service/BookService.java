package com.kimyena.memorydb.book.service;

import com.kimyena.memorydb.book.db.entity.BookEntity;
import com.kimyena.memorydb.book.db.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    //생성자 메서드
    // 이 BookService가 생성될 때, 아래에 있는 생성자 메서드도 생성할 건데, 이때 여기에 주입해주는게 Spring이 해주는 역할이다.
    //BookRepository를 생성자 메서드로 작성하게 되면, Spring은 Bean 영역에서 찾게된다.
    //이렇게 하면 손이 많이 간다. -> 그래서 @RequiredArgsContructor를 해주면 된다(Lombok에서 제공함) -> User쪽에 그렇게 되어 있으니, Book쪽은 생성자를 생성해서 하는 방식으로 한번 해보자.
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    //create, update
    public BookEntity create(BookEntity bookEntity) {
        return bookRepository.save(bookEntity);
    }

    //read - all
    public List<BookEntity> findAll() {
        return bookRepository.findAll();
    }

    //find - one
    public Optional<BookEntity> findById(Long id) {
        return bookRepository.findById(id);
    }

    //delete
    public void delete(Long id) {
        bookRepository.delete(id);
    }



}
