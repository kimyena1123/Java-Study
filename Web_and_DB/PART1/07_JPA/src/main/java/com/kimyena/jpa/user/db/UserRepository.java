package com.kimyena.jpa.user.db;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> { //같은 인터페이스이기 때문에 implements가 아니라 extends


}
