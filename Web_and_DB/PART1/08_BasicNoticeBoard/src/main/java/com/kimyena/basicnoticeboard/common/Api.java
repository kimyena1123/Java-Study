package com.kimyena.basicnoticeboard.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor //전체 필드 생성자
@NoArgsConstructor //기본 생성자
@ToString
@Builder
public class Api<T> {

    private T body;

    private Pagination pagination;
}
