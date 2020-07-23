package com.sungho.book.springboot.web;

import com.sungho.book.springboot.config.auth.SecurityConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.hamcrest.Matchers.is;

@RunWith(SpringRunner.class)//@RunWith: JUnit 테스트 외 다른 테스트를 실행 여기선 SpringRunner라는 스프링 테스트를 사용, 스프링 부트 테스트와 JUnit 사이의 연결자 역할
@WebMvcTest(controllers = HelloController.class, excludeFilters = {@ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, classes = SecurityConfig.class)})
public class HelloControllerTest {
//@WebMvcTest: Web(Spring MVC)에 집중할 수 있는 스프링 테스트 어노테이션

    @Autowired
    private MockMvc mvc; //private MockMvc mvc: 웹 API를 테스트할 때 사용, 스프링 MVC테스트의 시작점, 이 클래스를 통해 GET,POST등에 대한 API테스트 가능


    @WithMockUser(roles="USER")
    @Test
    public void hello가_리턴된다() throws Exception {
        String hello = "hello";

        mvc.perform(get("/hello")).andExpect(status().isOk()).andExpect(content().string(hello));
    } //mvc.perform(get("/hello")): MockMvc를 통해 /hello주소로 GET요청을 한다
      //.andExpect(status().isOk()): mvcperform의 결과를 검증, 200,404,500 등의 상태를 검증 여기선 OK 즉, 200인지 확인

      //.andExpect(content().string(hello)): Controller에서 리턴한 값이 hello가 맞는지 검증

    @WithMockUser(roles="USER")
    @Test
    public void helloDto가_리턴된다() throws Exception {
        String name = "hello";
        int amount = 1000;

        mvc.perform(
                get("/hello/dto")
                        .param("name", name)
                        .param("amount", String.valueOf(amount)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

        //.parm(): API테스트할 때 사용될 요청 파라미터를 설정 단 값은 String만 허용

        //.andExpect(jsonPath()): JSON응답값을 필드별로 검증하는 메소드 $를 기준으로 필드명 명시
    }
}
