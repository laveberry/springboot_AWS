package com.laveberry.config.auth;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //이 어노테이션 생성 위치 지정, 파라미터로 선언된 객체만 사용가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser { //@interface : 어노테이션 클래스
}
