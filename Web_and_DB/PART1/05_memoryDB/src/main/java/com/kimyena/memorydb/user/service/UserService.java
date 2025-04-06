package com.kimyena.memorydb.user.service;

import com.kimyena.memorydb.user.db.UserRepository;
import com.kimyena.memorydb.user.model.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public UserEntity save(UserEntity user){
        //save
        return userRepository.save(user);
    }

    public List<UserEntity> findAll(){
        //read
        return userRepository.findAll();
    }

    public Optional<UserEntity> findById(Long id){
        return userRepository.findById(id);
    }

    public void delete(UserEntity id){
        userRepository.delete(id);
    }

    //매개변수의 점수보다 같거나 큰경우의 정보를 리턴, 특정 점수 이상의 정보를 리턴
    public List<UserEntity> filterScore(int score){
        return userRepository.findAllByScoreGreaterThanEqual(score);
    }

    public List<UserEntity> filterScore(int min, int max){
        return userRepository.findAllByScoreGreaterThanEqualAndScoreLessThan(min, max);
    }

    //쿼리 메서드가 아닌 @Query로 jpql 문법 사용해보기. 기능은 위 메서드와 똑같음
    public List<UserEntity> score(int min, int max){
        return userRepository.score(min, max);
    }

    //쿼리 메서드도, jpql 문법도 아닌 sql(native sql)으로 접근해보기. 기능은 위 메서드와 똑같음
    public List<UserEntity> score2(int min, int max){
        return userRepository.score2(min, max);
    }

    //쿼리 메서드도, jpql 문법도 아닌 sql(native sql)으로 접근해보기. 쿼리문에서 ? 대신 별명으로 대체하기
    public List<UserEntity> score3(int min, int max){
        return userRepository.score3(min, max);
    }

}
