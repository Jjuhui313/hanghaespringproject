package com.sparta.hanghaespringproject.dto;

import com.sparta.hanghaespringproject.entity.Post;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Builder
@Getter
public class PostResponseDto {

    private String title;

    private String author;

    private String contents;

    private LocalDateTime createdAt;

    private LocalDateTime modifiedAt;


    public PostResponseDto(Post entity) {
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
        this.contents = entity.getContents();
        this.createdAt = entity.getCreatedAt();
        this.modifiedAt = entity.getModifiedAt();
    }

    public PostResponseDto(String title, String author, String contents, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.title = title;
        this.author = author;
        this.contents = contents;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}


