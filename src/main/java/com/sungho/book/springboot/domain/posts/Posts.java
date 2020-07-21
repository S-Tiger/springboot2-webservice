package com.sungho.book.springboot.domain.posts;


import com.sungho.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter //롬복의 어노테이션 클래스 내 모든 필드의 Getter 메소드를 자동생성
@NoArgsConstructor //롬복의 어노테이션 기본 생성자 자동추가
@Entity //JPA 어노테이션
public class Posts extends BaseTimeEntity { //실제 DB의 매칭될 클래스

    @Id //해당 테이블의 PK 필드를 나타내는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) //PK의 규칙을 나타내는 어노테이션
    //스트링부트 2.0 에선 GenerationType.IDENTITY 를 추가해야 auto_increment가 적용된다.
    private Long id;

    @Column(length = 500, nullable = false) //칼럼을 나타내여 문자열 경우 기본값은 255
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false) //타입을 TEXT로 변경하고 싶을경우
    private String content;

    private String author;

    @Builder //롬복의 어노테이션 해당 클래스의 빌더 패턴 클래스를 생성, 생성자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함
    public Posts(String title,String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title,String content){
        this.title = title;
        this.content = content;
    }

}
