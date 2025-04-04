package com.kimyena.memorydb.user.db;

import com.kimyena.memorydb.db.SimpleDataRepository;
import com.kimyena.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

}
