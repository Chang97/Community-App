package com.board.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.board.back.exception.ResourceNotFoundException;
import com.board.back.model.Board;
import com.board.back.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public List<Board> getAllBoard() {
		return boardRepository.findAll();
	}
	
	public Board createBoard(Board board) {
		return boardRepository.save(board);
	}
	
	public ResponseEntity<Board> getBoard(Integer no) {
		Board board = boardRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not Found Data no [" + no + "]"));
		return ResponseEntity.ok(board);
	}
}
