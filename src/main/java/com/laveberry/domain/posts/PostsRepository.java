package com.laveberry.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

//JpaRepository<Entity클래스, PK타입> : DB접근하게 해줌
public interface PostsRepository extends JpaRepository<Posts, Long> {

    //쿼리 직접 작성도 가능
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();

}
