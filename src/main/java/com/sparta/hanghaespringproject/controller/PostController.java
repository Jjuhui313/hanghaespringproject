package com.sparta.hanghaespringproject.controller;

import com.sparta.hanghaespringproject.dto.PostRequestDto;
import com.sparta.hanghaespringproject.dto.PostResponseDto;
import com.sparta.hanghaespringproject.entity.Post;
import com.sparta.hanghaespringproject.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class PostController {

    private final PostService postService;

//    @GetMapping("/")
//    public ModelAndView home() {
//        return new ModelAndView("index");
//    }

    @PostMapping("/api/post")
    public Post createPost(@RequestBody PostRequestDto requestDto) {
        return postService.createPost(requestDto);
    }

    @GetMapping("/api/posts")
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/api/posts/{id}")
    public PostResponseDto getPost(@PathVariable Long id) {
        return postService.findById(id);
    }

    @PutMapping("/api/posts/{id}/{password}")
    public PostResponseDto updatePost(@PathVariable Long id, @PathVariable String password, @RequestBody PostRequestDto requestDto) {
        return postService.update(id, password, requestDto);
    }

    @DeleteMapping("/api/posts/{id}/{password}")
    public String deletePost(@PathVariable Long id, @PathVariable String password) {
        return postService.deletePost(id, password);
    }

}
