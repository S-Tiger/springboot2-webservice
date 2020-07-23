package com.sungho.book.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

//@EnableJpaAuditing //JPA Auditing 활성화
@SpringBootApplication
public class Application {  //Application 클래스는 메인 클래스
    public static void main(String[] args) {
        SpringApplication.run(Application.class , args);
    }
}

    //1. @SpringBootApplication으로 인해 스프링 부트의 자동 설정, Bean읽기와 생성 모두 자동설정
    //해당 어노테이션이 있는 위치부터 설정을 읽어가기 때문에 이 클래스는 항상 프로젝트 최상단에 위치

    //2. SpringApplication.run 으로 인해 내장 WAS를 실행