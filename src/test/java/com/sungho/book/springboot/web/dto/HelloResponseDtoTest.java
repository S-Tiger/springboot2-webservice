package com.sungho.book.springboot.web.dto;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class HelloResponseDtoTest {

    @Test
    public void 롬복_기능_테스트() {

        String name = "test";
        int amount = 1000;

        HelloResponseDto dto = new HelloResponseDto(name,amount);

        assertThat(dto.getName()).isEqualTo(name);
        assertThat(dto.getAmount()).isEqualTo(amount);
        //assertThat: assertj 라는 테스트 검증 라이브러리 메소드
        //검증하고 싶은 대상을 메소드 인자로 받는다, 메소드 체이닝이 지원되어 isEqualTo와 같이 메소드를 이어서 사용가능

        //isEqualTo: assertj 의 동등 비교 메소드 assertThat에 있는 값과 isEqualTo의 값을 비교해 같을경우만 성공
    }
}
