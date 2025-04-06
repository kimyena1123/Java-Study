package com.kimyena.memorydb.user.db;

import com.kimyena.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
