package com.laveberry.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)//(1)RunWith : 스프링부트테스트와 JUnuit 연결자
@WebMvcTest(controllers = HelloController.class)//(2)WebMvcTest : springMVC집중
public class HelloControllerTest {

    @Autowired //(3)빈주입
    private MockMvc mvc; //(4)MockMvc : 스프링API테스트 시작점

    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) //(5)url Get 요청
                .andExpect(status().isOk())  //(6)(7)Http header status(200) 결과검증
                .andExpect(content().string(hello)); //(8)응답본문내용 검증
    }
}