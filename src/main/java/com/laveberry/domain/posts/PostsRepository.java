package com.laveberry.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//JpaRepository<Entity클래스, PK타입> : DB접근하게 해줌
public interface PostsRepository extends JpaRepository<Posts, Long> {
}
