package com.laveberry;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트 자동설정, Bean 읽기와 생성 자동
public class Main {
    public static void main(String[] args) {
        //내장 WAS 실행 : 같은 환경에서 스프링부트 배포 가능
        SpringApplication.run(Main.class, args);
        System.out.println("Hello world!");
    }
}