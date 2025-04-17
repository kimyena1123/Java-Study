package com.kimyena.http_cookie.db;

import com.kimyena.http_cookie.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserRepository {

    private final List<UserDto> userList = new ArrayList<>();

    @PostConstruct
    public void start(){
        userList.add(new UserDto(UUID.randomUUID().toString(), "홍길동", "1234"));
        userList.add(new UserDto(UUID.randomUUID().toString(), "나길동", "1234"));
        userList.add(new UserDto(UUID.randomUUID().toString(), "박길동", "1234"));
    }

    public Optional<UserDto> findById(String id){
        return userList.stream().filter(userDto -> userDto.getId().equals(id)).findFirst();
    }

    public Optional<UserDto> findByName(String name){
        return userList.stream().filter(userDto -> userDto.getName().equals(name)).findFirst();
    }
}
