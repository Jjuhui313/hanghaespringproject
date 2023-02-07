package com.sparta.hanghaespringproject.service;

import com.sparta.hanghaespringproject.dto.PostRequestDto;
import com.sparta.hanghaespringproject.dto.PostResponseDto;
import com.sparta.hanghaespringproject.entity.Post;
import com.sparta.hanghaespringproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public PostResponseDto createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);


        return PostResponseDto.builder()
                .createdAt(post.getCreatedAt())
                .modifiedAt(post.getModifiedAt())
                .title(post.getTitle())
                .author(post.getAuthor())
                .contents(post.getContents())
                .build();
    }

    @Transactional(readOnly = true)
    public List<PostResponseDto> getPosts() {
        return postRepository.findAllByOrderByCreatedAtDesc().stream().map(PostResponseDto::new).collect(Collectors.toList());
    }


    public PostResponseDto findById(Long id) {
        Post entity = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("해당 게시글은 존재하지 않습니다.")
        );
        return new PostResponseDto(entity);
    }

    @Transactional
    public PostResponseDto update(Long id, String password, PostRequestDto requestDto) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        post.update(requestDto, password);
        return new PostResponseDto(post);
    }

    @Transactional
    public String deletePost(Long id, String password) {
        Post delPost = postRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if(delPost.delete(password)) {
            postRepository.deleteById(id);
            return "{\"success\":\"true\"}";
        } else {
            return "삭제실패";
        }

    }

}
