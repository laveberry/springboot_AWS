package com.laveberry.web;

import com.laveberry.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)//(1)RunWith : 스프링부트테스트와 JUnuit 연결자
@WebMvcTest(controllers = HelloController.class,
        excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)
        }
)//(2)WebMvcTest : springMVC집중  / 시큐리티 테스트 위해 스캔대상에서 SecurityConfig 제거
public class HelloControllerTest {

    @Autowired //(3)빈주입
    private MockMvc mvc; //(4)MockMvc : 스프링API테스트 시작점

    @Test
    @WithMockUser(roles = "USER")
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";
        mvc.perform(get("/hello")) //(5)url Get 요청
                .andExpect(status().isOk())  //(6)(7)Http header status(200) 결과검증
                .andExpect(content().string(hello)); //(8)응답본문내용 검증
    }


    @Test
    @WithMockUser(roles = "USER")
    public void helloDto가_리턴된다() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name) //1.param : API호출시 요청 파라미터. String만 가능
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))//2.jsonPath :json응답값 필드별($.필드명) 검증
                .andExpect(jsonPath("$.amount", is(amount)));
    }
}