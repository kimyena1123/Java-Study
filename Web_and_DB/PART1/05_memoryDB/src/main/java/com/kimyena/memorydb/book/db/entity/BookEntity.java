package com.kimyena.memorydb.book.db.entity;

import com.kimyena.memorydb.entity.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity extends Entity {

    private String name;
    private String category;
    private BigDecimal amount; //가격
}
