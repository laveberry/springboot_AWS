package com.laveberry.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass //jpa entity 클래스들이 해당클래스 상속시 필드(createdDate..)들도 칼럼으로 인식
@EntityListeners(AuditingEntityListener.class) //Auditing기능 포함
public class BaseTimeEntity {

    @CreatedDate //엔티티 생성되어 저장시 시간 자동저장
    private LocalDateTime createdDate;

    @LastModifiedDate //조회 엔티티 값 변경시 시간 자동저장
    private LocalDateTime modifiedDate;

}
