package com.kimyena.http_session.service;

import com.kimyena.http_session.db.UserRepository;
import com.kimyena.http_session.model.LoginRequest;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ){
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(id); //사용자가 입력한 id를 repository에 넘겨서 repository에서 찾아서, 있는 id이면 해당 유저 정보를 넘겨준다.
        System.out.println("repository에서 받은 optionalUser 정보: " + optionalUser); //optionalUser에는 해당 유저의 정보가 담겨있음

        if(optionalUser.isPresent()) { //사용자가 입력한 id값이 있다면(서버에 저장되어 있다면)
            //유저가 있으면 UserDto를 뽑아낸다.
            var userDto = optionalUser.get(); //서버에 입력되어 있는, 사용자가 입력한 id값
            System.out.println("userDto: " + userDto.toString());

            if(userDto.getPassword().equals(pw)) { //사용자가 입력한 pw와 서버에 저장된 pw가 같다면
                //id와 pw가 같으니, 세션에 정보 저장
                httpSession.setAttribute("USER", userDto); //userDto 정보를 세션에 저장

            }else{
                throw new RuntimeException("패스워드가 틀렸습니다. 다시 한번 시도해주세요");

            }


        }else{ //사용자가 입력한 id값이 없다면(틀린 id값이거나, 서버에 정보가 없거나)
            throw new RuntimeException("존재하지 않는 유저입니다. ");
        }


    }
}
