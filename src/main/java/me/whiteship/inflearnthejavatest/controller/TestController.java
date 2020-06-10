package me.whiteship.inflearnthejavatest.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @PostMapping(value = "/api/v1/posts", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public PostsSaveRequestDto requestBodyToObject(@RequestBody PostsSaveRequestDto postsSaveRequestDto) {
        System.out.println("-- requestBodyToObject --");
        System.out.println(postsSaveRequestDto);
        return postsSaveRequestDto;
    }

    @PostMapping(value = "/api/v2/posts", consumes = "application/x-www-form-urlencoded;charset=UTF-8")
    public ResponseEntity<?> requestBodyToMultiValueMap(@RequestBody MultiValueMap<String, String> postsSaveRequestDto) {
        System.out.println("-- requestBodyToMultiValueMap --");
        System.out.println(postsSaveRequestDto);
        return ResponseEntity.ok().build();
    }

}
