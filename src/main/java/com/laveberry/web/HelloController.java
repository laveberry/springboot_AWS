package com.laveberry.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //json반환
public class HelloController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

}
