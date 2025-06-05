package org.delivery.storeadmin.domain.user.service;

import lombok.RequiredArgsConstructor;
import org.delivery.db.storeuser.StoreUserEntity;
import org.delivery.db.storeuser.StoreUserRepository;
import org.delivery.db.storeuser.enums.StoreUserStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StoreUserService {

    private final StoreUserRepository storeUserRepository;
    private final PasswordEncoder passwordEncoder; //PasswordEncoder를 bean으로 등록했기 때문에 interface처럼 불러올 수 있다.

    //CREATE(가맹점 유저 가입)
    //새로운 점주 사용자(store user)를 등록하는 메소드
    //ex) 스타벅스 점주가 점주용 웹사이트(관리자 페이지)에 회원가입 양식을 작성해서 제출하면,
    //    이 register() 메소드가 호출되어 입력한 비밀번호는 암호화되고, 해당 점주는 "REGISTERED" 상태로 DB에 저장된다
    public StoreUserEntity register(
            StoreUserEntity storeUserEntity
    ){
        storeUserEntity.setStatus(StoreUserStatus.REGISTERED);
        storeUserEntity.setPassword(passwordEncoder.encode(storeUserEntity.getPassword())); //외부에서 넘겨준 storeUserEntity 값을 encode해서 값을 세팅할 거다.
        storeUserEntity.setRegisteredAt(LocalDateTime.now());

        return storeUserRepository.save(storeUserEntity);
    }

    //READ: 로그인(email로 로그인) - 주어진 이메일로 등록된 점주 사용자 정보를 조회
    //SELECT * FROM store_user WHERE email = ? AND status = ? ORDER BY id DESC LIMIT 1
    public Optional<StoreUserEntity> getRegisterUser(String email){
        return storeUserRepository.findFirstByEmailAndStatusOrderByIdDesc(email, StoreUserStatus.REGISTERED);
    }
}
