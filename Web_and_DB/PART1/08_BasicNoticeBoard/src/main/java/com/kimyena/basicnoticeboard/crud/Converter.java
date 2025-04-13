package com.kimyena.basicnoticeboard.crud;

public interface Converter<DTO, ENTITY> {

    abstract DTO toDTO(ENTITY entity); //entity를 받아서 dto로 반환해주는 추상메서드
    abstract ENTITY toEntity(DTO dto); //dto를 받아서 entity로 반환해주는 추상메서드
}
