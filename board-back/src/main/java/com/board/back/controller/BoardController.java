package com.board.back.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	
//	@GetMapping("/board")
//	public ResponseEntity<Map> getAllBoards(@RequestParam(value = "pageNo", required=false) Integer pageNo) {
//		if (pageNo == null || pageNo <= 0)
//			pageNo = 1;
//		return boardService.getPagingBoard(pageNo);
//	}
	
	@GetMapping("/board")
	public Page<Board> getAllBoards(@PageableDefault(size = 10, sort="no", direction = Sort.Direction.DESC) Pageable pageable) {
		
		return boardService.getPagingBoard(pageable);
	}
	
	@PostMapping("/board")
	public Board createBoard(@RequestBody Board board) {
		return boardService.createBoard(board);
	}
	
	@GetMapping("/board/{no}")
	public ResponseEntity<Board> createBoard(@PathVariable Integer no) {
		return boardService.getBoard(no);
	}
	
	@PutMapping("/board/{no}")
	public ResponseEntity<Board> updateBoard(@PathVariable Integer no, @RequestBody Board board) {
		return boardService.updateBoard(no, board);
	}
	
	@DeleteMapping("/board/{no}")
	public ResponseEntity<Map<String, Boolean>> deleteBoard(@PathVariable Integer no) {
		return boardService.deleteBoard(no);
	}
	
}
