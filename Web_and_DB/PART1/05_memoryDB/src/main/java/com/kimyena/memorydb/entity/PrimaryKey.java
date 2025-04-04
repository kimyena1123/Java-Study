package com.kimyena.memorydb.entity;

public interface PrimaryKey {

    //PrimaryKey가 가지게 되는 인터페이스는 해당 아이디를 지정할 것이기 때문에,
    void setId(Long id);

    Long getId();
}
