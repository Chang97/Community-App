package com.board.back.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.model.Board;
import com.board.back.service.BoardService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@GetMapping("/board")
	public List<Board> getAllBoards() {
		return boardService.getAllBoard();
	}
	
	@PostMapping("/create-board")
	public Board createBoard(Board board) {
		return boardService.createBoard(board);
	}
	
}
