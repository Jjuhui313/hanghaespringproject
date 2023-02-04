package com.sparta.hanghaespringproject.dto;

import com.sparta.hanghaespringproject.entity.Post;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class PostResponseDto {

    private String title;

    private String author;

    private String contents;

    private LocalDateTime createdAt;



    public PostResponseDto(Post entity) {
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.contents = entity.getContents();
        this.createdAt = entity.getCreatedAt();
    }
}


