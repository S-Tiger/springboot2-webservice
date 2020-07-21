package com.sungho.book.springboot.service.posts;


import com.sungho.book.springboot.domain.posts.PostsRepository;
import com.sungho.book.springboot.web.dto.PostsSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor //롬복의 어노테이션 final이 선언된 모든 필드를 자동 생성 @Autowired를 사용 안해도된다
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return  postsRepository.save(requestDto.toEntity()).getId();

    }
}
