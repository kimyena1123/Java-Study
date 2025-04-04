package com.kimyena.memorydb.book.controller;

import com.kimyena.memorydb.book.db.entity.BookEntity;
import com.kimyena.memorydb.book.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/book")
@RequiredArgsConstructor
public class BookApiController {

    //아래 코드를 실행하기 위해서 @RequiredArgsConstructor 사용
    private final BookService bookService;

    //create, update
    @PutMapping("")
    public BookEntity create(
            @RequestBody BookEntity bookEntity
    ){
        return bookService.create(bookEntity);
    }

    //read - findAll
    @GetMapping("/all")
    public List<BookEntity> findAll() {
        return bookService.findAll();
    }

    //read - findOne
    @GetMapping("/read/id/{bookId}")
    public Optional<BookEntity> findById(
            @PathVariable Long bookId
    ){
        return bookService.findById(bookId);
    }

    //delete
    @DeleteMapping("/delete/id/{bookId}")
    public void deleteById(
            @PathVariable Long bookId
    ){
        bookService.delete(bookId);
    }

}
