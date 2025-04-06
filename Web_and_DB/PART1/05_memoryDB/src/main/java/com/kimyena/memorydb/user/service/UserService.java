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

    //매개변수의 점수보다 같거나 큰경우의 정보를 리턴
    public List<UserEntity> filterScore(int score){
        return null;
//        return userRepository.findAllScoreGreaterThen(score);
    }

}
