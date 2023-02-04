package com.sparta.hanghaespringproject.dto;

import lombok.Getter;

@Getter
public class PostRequestDto {
    private String author;
    private String title;
    private String content;
    private String password;
}
