package com.kimyena.http_session.db;

import com.kimyena.http_session.model.UserDto;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserRepository { //현재 DB가 없기 때문에 repository에 아래와 같은 정보를 넣음.

    private List<UserDto> userList = new ArrayList<>(); //여러 명의 유저 => List

    @PostConstruct //의존성 주입이 이루어진 후 초기화를 수행하는 메서드. 생성자가 호출되었을 때, bean은 초기화 전이다. bean이 초기화 됨과 동시에 의존성을 확인할 수 있다.(여러 번 초기화 방지)
    public void init(){

        //DB 연결을 안해서 유저를 만들어주자. 그럼 초기화가 됐을 떄 아래 3명의 정보가 들어가 있을 것이다.
        userList.add(new UserDto("짱구", "1234"));
        userList.add(new UserDto("짱아", "1234"));
        userList.add(new UserDto("철수", "1234"));
    }

    //사용자 이름 찾기
    public Optional<UserDto> findByName(String name){
        return userList.stream().filter( it -> {
            return it.getName().equals(name);
        }).findFirst();
    }
}
