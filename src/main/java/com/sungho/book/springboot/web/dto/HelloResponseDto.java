package com.sungho.book.springboot.web.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter //롬복의 어노테이션 선언된 모든 필드의 get메소드를 생성해줌
@RequiredArgsConstructor //롬복의 어노테이션 선언된 모든 final 필드가 포함된 생성자를 생성, final이 없는 필드는 생성하지 않는다.
public class HelloResponseDto {

    private final String name;
    private final int amount;
}
