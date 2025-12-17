package com.example.demo.service;

import com.example.demo.dto.BoardRequestDto;
import com.example.demo.dto.BoardResponseDto;
import com.example.demo.dto.SuccessResponseDto;
import com.example.demo.entity.Board;
import com.example.demo.repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional(readOnly = true)
    public List<BoardResponseDto> getPosts(){ // 전체 조회
        return boardRepository.findAllByOrderByModifiedAtDesc().stream().map(BoardResponseDto::new).toList();
    }

    @Transactional
    public BoardResponseDto createPost(BoardRequestDto requestDto){ // 게시글 생성
        Board board = new Board(requestDto);
        boardRepository.save(board);
        return new BoardResponseDto(board);
    }

    @Transactional
    public BoardResponseDto getPost(Long id){ // 선택 조회
        return boardRepository.findById(id).map(BoardResponseDto::new).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
    }

    @Transactional
    public BoardResponseDto updatePost(Long id, BoardRequestDto requestDto){ // 게시글 수정
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );
        if (!requestDto.getPassword().equals(board.getPassword()))
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        board.update(
                requestDto.getTitle(),
                requestDto.getContent(),
                requestDto.getAuthor()
        );
        return new BoardResponseDto(board);
    }

    @Transactional
    public void deletePost(Long id, BoardRequestDto requestDto){ // 게시글 삭제
        Board board = boardRepository.findById(id).orElseThrow(
                () -> new IllegalArgumentException("아이디가 존재하지 않습니다.")
        );

        if(!requestDto.getPassword().equals(board.getPassword()))
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        boardRepository.delete(board);
    }
}
