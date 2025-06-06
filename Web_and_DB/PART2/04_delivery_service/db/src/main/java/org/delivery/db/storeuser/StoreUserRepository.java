package org.delivery.db.storeuser;

import org.delivery.db.storeuser.enums.StoreUserStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface StoreUserRepository extends JpaRepository<StoreUserEntity, Long> {

    //로그인할 때 사용됨(email로 로그인)
    //SELECT * FROM store_user WHERE email = ? AND status = ? ORDER BY id DESC LIMIT 1
    Optional<StoreUserEntity> findFirstByEmailAndStatusOrderByIdDesc(String email, StoreUserStatus status);
}
