package com.example.demo.controller;

import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController   // ⭐️ 핵심 변경
@RequiredArgsConstructor
@RequestMapping("/api/posts") // ⭐️ 공통 주소 묶기
public class BoardController {

    private final BoardService boardService;

    // 전체 조회
    @GetMapping
    public List<BoardResponseDto> getPosts() {
        return boardService.getPosts();
    }

    // 단건 조회
    @GetMapping("/{id}")
    public BoardResponseDto getPost(@PathVariable Long id) {
        return boardService.getPost(id);
    }

    // 생성
    @PostMapping
    public BoardResponseDto createPost(@RequestBody BoardRequestDto requestDto) {
        return boardService.createPost(requestDto);
    }

    // 수정
    @PutMapping("/{id}")
    public BoardResponseDto updatePost(
            @PathVariable Long id,
            @RequestBody BoardRequestDto requestDto) {
        return boardService.updatePost(id, requestDto);
    }

    // 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable Long id, @RequestBody BoardRequestDto requestDto) {
        boardService.deletePost(id,  requestDto);
        return ResponseEntity.noContent().build();
    }
}
