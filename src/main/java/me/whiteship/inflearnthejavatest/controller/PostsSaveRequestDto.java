package me.whiteship.inflearnthejavatest.controller;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@Builder
public class PostsSaveRequestDto {

    private String title;
    private String author;
    private String content;

}
