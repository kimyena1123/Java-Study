package com.kimyena.http_cookie.model;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder
public class UserDto { // Request -> Controller  <- [DTO] -> Service <- [DTO] -> Repository <- [ENTITY] -> DB

    private String id;

    private String name;

    private String password;
}
