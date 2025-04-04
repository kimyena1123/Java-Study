package com.kimyena.memorydb.user.db;

import com.kimyena.memorydb.db.SimpleDataRepository;
import com.kimyena.memorydb.user.model.UserEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRepository extends SimpleDataRepository<UserEntity, Long> {

    //매개변수에 들어온 점수보다 더 큰 점수를 받은 사람의 정보를 보여주는 메서드
    public List<UserEntity> findAllScoreGreaterThen(int score){

        return this.findAll().stream() // 전체 list 중에서 stream으로 filter를 걸거다.
                .filter(
                        it -> {
                            return it.getScore() >= score; // it.getScore(): db에 들어있는 각 객체의 score가, 매개변수로 들어온 score보다 같거나 큰 경우를 리턴해준다.
                        }
                ).toList();
    }


}
