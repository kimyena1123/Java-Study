package com.kimyena.memorydb.db;

import java.util.List;
import java.util.Optional;

public interface DataRepository <T, ID> extends Repository<T, ID>{
    //CRUD 기능을 인터페이스로

    //데이터의 아이디를 통해서 데이터 리턴하는 메서드
    //데이터가 있을 수도 있고, 없을 수도 있기에 optional로 리턴타입을 해준다.
    //read - 한 개의 데이터 return
    Optional<T> findById(ID id);

    //read - 여러 개의 데이터 return
    List<T> findAll();

    //create, update
    T save(T data);

    //delete
    void delete(ID id);

}
