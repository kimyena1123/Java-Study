package com.kimyena.memorydb.db;

import com.kimyena.memorydb.entity.Entity;

import java.util.*;

abstract class SimpleDataRepository<T extends Entity, ID extends Long> implements DataRepository<T, ID> {

    private List<T> dataList = new ArrayList<>();
    private static long index = 0;
    private Comparator<T> sort = new Comparator<T>() {
        @Override
        public int compare(T o1, T o2) {
            return Long.compare(o1.getId(), o2.getId());
        }
    };


    //create
    @Override
    public T save(T data) {
        if(Objects.isNull(data)) {
            throw new RuntimeException("data is null");
        }

        //db에 데이터가 있는가?
        var prevData = dataList.stream()
                .filter(it -> {
                    return it.getId().equals(data.getId()); //현재 들어있는 데이터의 getID와 Object, 즉 data가 가지고 있는 id가 동일한 경우
                })
                        .findFirst();

        if(prevData.isPresent()) { //기존 데이터가 있는 경우 -> update -> 그 기존 데이터 삭제하고, 다시 집어넣음
            dataList.remove(prevData);
            dataList.add(data);
        }else{ //기존 데이터가 없는 경우 -> create
            index++;
            //unique iś
            data.setId(index);
            dataList.add(data);
        }
        return data;

    }

    //read
    @Override
    public Optional<T> findById(ID id) { //데이터가 있을 수도 있고 없을 수도 있어서 리턴타입은 Optional
        return dataList.stream()
                .filter(it -> {
                    return ( it.getId().equals(id));
                })
                .findFirst();
    }

    @Override
    public List<T> findAll() {
        return dataList.stream()
                .sorted(sort)
                .toList();
    }

    //delete
    @Override
    public void delete(ID id) {
        var deleteEntity = dataList.stream()
                .filter(it -> {
                    return ( it.getId().equals(id));
                })
                .findFirst();

        if(deleteEntity.isPresent()) {
            dataList.remove(deleteEntity);
        }
    }




}
