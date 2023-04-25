package com.laveberry.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //jpa어노테이션. 테이블과 링크될 클래스임을 나타냄
public class Posts { //Entity Class : 실제 DB에 매칭될 클래스, Setter 만들지 않음!
    @Id //PK
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK생성규칙
    private Long id;

    //@Column : 테이블 컬럼 나타냄. 옵션없을경우 선언안해도 됨
    @Column(length = 500, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }
}
