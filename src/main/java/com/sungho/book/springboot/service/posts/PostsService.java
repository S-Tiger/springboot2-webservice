package com.sungho.book.springboot.service.posts;


import com.sungho.book.springboot.domain.posts.Posts;
import com.sungho.book.springboot.domain.posts.PostsRepository;
import com.sungho.book.springboot.web.dto.PostsListRseponseDto;
import com.sungho.book.springboot.web.dto.PostsResponseDto;
import com.sungho.book.springboot.web.dto.PostsSaveRequestDto;
import com.sungho.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //롬복의 어노테이션 final이 선언된 모든 필드를 자동 생성 @Autowired를 사용 안해도된다
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return  postsRepository.save(requestDto.toEntity()).getId();

    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));
        posts.update(requestDto.getTitle(),requestDto.getContent());
        return  id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id="+ id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public List<PostsListRseponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream().map(PostsListRseponseDto::new).collect(Collectors.toList());
    }

    @Transactional
    public void delete (Long id){
        Posts posts = postsRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));
        postsRepository.delete(posts);


    }
}
