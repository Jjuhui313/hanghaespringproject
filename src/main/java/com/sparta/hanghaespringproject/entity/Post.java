package com.sparta.hanghaespringproject.entity;

import com.sparta.hanghaespringproject.dto.PostRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Getter
@Entity
@NoArgsConstructor
public class Post extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String contents;

    @Column
    private String password;


    public Post(PostRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.author = requestDto.getAuthor();
        this.contents = requestDto.getContent();
        this.password = requestDto.getPassword();

    }

    public void update(PostRequestDto requestDto, String password) {
        if(password.equals(this.password)) {
            this.title = requestDto.getTitle();
            this.author = requestDto.getAuthor();
            this.contents = requestDto.getContent();
        }


    }

    public boolean delete(String password) {
        if(password.equals(this.password)) {
            return true;
        }
        return false;
    }
}
