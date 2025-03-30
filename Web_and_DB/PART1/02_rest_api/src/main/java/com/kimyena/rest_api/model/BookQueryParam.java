package com.kimyena.rest_api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestParam;

@Data //Lombok을 할 때 사용하는 어노테이션
@AllArgsConstructor
@NoArgsConstructor
public class BookQueryParam {
    private String category;
    private String issuedYear;
    private String issuedMonth;
    private String issuedDay;

}
