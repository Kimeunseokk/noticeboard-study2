package com.example.demo.controller;

import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Controller
@RequiredArgsConstructor // final 붙은 생성자만 해당하는 애너테이션
public class BoardController {

    private final BoardService boardService;

    @GetMapping("/api/posts") // 조회
    public List<BoardResponseDto> getPosts() {
        return boardService.getPosts();
    }

    @PostMapping("/api/post") // 생성
    public BoardResponseDto createPosts(@RequestBody BoardRequestDto requestDto) {
        return boardService.createPost(requestDto);
    }

    @GetMapping("/api/post/{id}")
    public BoardResponseDto getPost(@PathVariable Long id) {
        return boardService.getPost(id);
    }


}
