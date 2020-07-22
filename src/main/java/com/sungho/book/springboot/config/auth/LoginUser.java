package com.sungho.book.springboot.config.auth;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.PARAMETER) //이 어노테이션의 생성위치를 지정 parameter로 지정했으니 메소드의 파라미터로 선언된 객체에서만 사용 가능
@Retention(RetentionPolicy.RUNTIME)
public @interface LoginUser {
    //@interface: 이 파일을 어노테이션 클래스로 한다 LoginUser라는 이름을 가진 어노테이션을 생성한다고 보면 된다


}
