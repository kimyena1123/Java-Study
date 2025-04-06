package com.kimyena.memorydb.book.db.repository;

import com.kimyena.memorydb.book.db.entity.BookEntity;
 import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {

}
