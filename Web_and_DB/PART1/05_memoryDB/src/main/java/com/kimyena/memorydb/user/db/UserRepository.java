package com.kimyena.memorydb.user.db;

import com.kimyena.memorydb.user.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //select * from user where score > [??]; //쿼리
    public List<UserEntity> findAllByScoreGreaterThanEqual(int score); //쿼리 메서드
    // 이제는 위와 같이 쿼리로 날리지 않고, 메서드 형식의 자바문법으로 쿼리를 날리는 것임.
    //쿼리 메서드: spring data jpa reference : https://docs.spring.io/spring-data/jpa/docs/current-SNAPSHOT/reference/html/#jpa.query-methods.query-creation

    //특정 점수보다 크고, 특정 점수보다는 낮은.
    //쿼리문 : select * from user where score >= ?? and score <= ??
    List<UserEntity> findAllByScoreGreaterThanEqualAndScoreLessThan(int min, int max);

    //쿼리 메서드가 아닌 jpql 문법으로 접근해보기
    @Query(
            "SELECT u FROM user AS u WHERE u.score >= ?1 AND u.score <= ?2"
    )
    List<UserEntity> score(int min, int max);


    //쿼리 메서드도, jpql 문법도 아닌 sql(native sql)으로 접근해보기
    @Query(
            value = "SELECT * FROM user AS u WHERE u.score >= ?1 AND u.score <= ?2",
            nativeQuery = true
    )
    List<UserEntity> score2(int min, int max);

    //쿼리 메서드도, jpql 문법도 아닌 sql(native sql)으로 접근해보기. 쿼리문에서 ? 대신 별명으로 대체하기
    @Query(
            value = "SELECT * FROM user AS u WHERE u.score >= :min AND u.score <= :max",
            nativeQuery = true
    )
    List<UserEntity> score3(
            @Param(value = "min") int min,
            @Param(value = "max") int max);


}
