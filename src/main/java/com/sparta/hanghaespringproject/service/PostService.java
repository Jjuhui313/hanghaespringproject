package com.sparta.hanghaespringproject.service;

import com.sparta.hanghaespringproject.dto.PostRequestDto;
import com.sparta.hanghaespringproject.dto.PostResponseDto;
import com.sparta.hanghaespringproject.entity.Post;
import com.sparta.hanghaespringproject.repository.PostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Post createPost(PostRequestDto requestDto) {
        Post post = new Post(requestDto);
        postRepository.save(post);
        return post;
    }

    @Transactional(readOnly = true)
    public List<Post> getPosts() {
        return postRepository.findAllByOrderByModifiedAtDesc();
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
