package com.kimyena.basicnoticeboard.post.db;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<PostEntity, Long> {

    //select * from post wherre id = ? and status = ? order by id desc limit 1
    Optional<PostEntity> findFirstByIdAndStatusOrderByIdDesc(Long id, String status);
}
