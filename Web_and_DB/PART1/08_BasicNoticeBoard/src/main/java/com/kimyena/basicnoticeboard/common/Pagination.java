package com.kimyena.basicnoticeboard.common;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor //전체 필드 생성자
@NoArgsConstructor //기본 생성자
@ToString
@Builder
public class Pagination {
    //pagination에는 필요한 내용이 몇가지 있다. 현재 페이지, 총 size, 현재 가지고 있는 element가 몇 개인지, 총 페이지, 전체 element가 몇개인지

    private Integer page;
    private Integer size;
    private Integer currentElements;
    private Integer totalPage;
    private Long totalElements; //주의) totalElements는 Long 타입이다.전체 개수가 많을 수 있기 떄문에 Integer가 아니라 Long으로 받아줘야 햔다.
}
