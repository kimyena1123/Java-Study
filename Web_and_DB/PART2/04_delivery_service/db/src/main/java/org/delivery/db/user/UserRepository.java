package org.delivery.db.user;

import org.delivery.db.user.enums.UserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> { //어떠한 Enitty를 참고할 건지 지정, primary key(id)

    //자주 사용하는 메서드 몇 가지만 미리 user table에 만들어놓기

    //사용자 찾기: 쿼리메소드 사용(SELECT * FROM user WHERE id =  AND status = ? ORDER BY id DESC LIMIT 1;)
    Optional<UserEntity> findFirstByIdAndStatusOrderByIdDesc(Long userId, UserStatus status);

    //로그인할 때 사용 (SELECT * FROM user WHERE email = ? AND password = ? AND status = ? ORDER BY id DESC LIMIT 1)
    Optional<UserEntity> findFirstByEmailAndPasswordAndStatusOrderByIdDesc(String email, String password, UserStatus status);
}
