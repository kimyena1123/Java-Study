package com.kimyena.memorydb.book.db.repository;

import com.kimyena.memorydb.book.db.entity.BookEntity;
import com.kimyena.memorydb.db.SimpleDataRepository;
import com.kimyena.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class BookRepository extends SimpleDataRepository<BookEntity, Long> {

}
