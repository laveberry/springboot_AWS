package com.laveberry.service.posts;

import com.laveberry.domain.posts.Posts;
import com.laveberry.domain.posts.PostsRepository;
import com.laveberry.web.dto.PostsListResponseDto;
import com.laveberry.web.dto.PostsResponseDto;
import com.laveberry.web.dto.PostsSaveRequestDto;
import com.laveberry.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor //생성자로 Bean주입받기. @Autowired와 동일효과
@Service
public class PostsService {

    private final PostsRepository postsRepository;

    @Transactional
    public Long save(PostsSaveRequestDto requestDto){
        return postsRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostsUpdateRequestDto requestDto){
        Posts posts = postsRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id ="+ id));

        posts.update(requestDto.getTitle(), requestDto.getContent());
        return id;
    }

    public PostsResponseDto findById(Long id){
        Posts entity = postsRepository.findById(id)
                .orElseThrow(()->new IllegalArgumentException("해당 게시글이 없습니다. id="+id));

        return new PostsResponseDto(entity);
    }

    @Transactional(readOnly = true) //조회기능 트랜잭션 범위 유지
    public List<PostsListResponseDto> findAllDesc(){
        return postsRepository.findAllDesc().stream()
                .map(PostsListResponseDto::new) //map(posts -> new PostsListResponseDto(Posts))
                .collect(Collectors.toList());
    }
}
