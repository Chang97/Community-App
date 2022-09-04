package com.board.back.service;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.board.back.exception.ResourceNotFoundException;
import com.board.back.model.Board;
import com.board.back.repository.BoardRepository;
import com.board.back.util.PagingUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardService {
	@Autowired
	private BoardRepository boardRepository;
	
	public int findAllCount() {
		return (int) boardRepository.count();
	}
	/*
	 * 게시글 출력
	 */
//	public ResponseEntity<Map> getPagingBoard(Integer pageNo) {
//
//		Map result = null;
//		
//		PagingUtil pu = new PagingUtil(pageNo, 5, 5);
//		List<Board> list = boardRepository.findFromTo(pu.getObjectStartNum(), pu.getObjectCountPerPage());
//		
//		pu.setObjectCountTotal(findAllCount());
//		pu.setCalcForPaging();
//		
//		log.info("pageNo : " + pageNo);
//		log.info(pu.toString());
//		
//		if (list == null || list.size() == 0) {
//			return null;
//		}
//		
//		result = new HashMap<>();
//		result.put("pagingData", pu);
//		result.put("list", list);
//		
//		return ResponseEntity.ok(result);
//
//	}
	public Page<Board> getPagingBoard(Pageable pageable) {
		return boardRepository.findAll(pageable);
	}
	
	/*
	 * 글 생성
	 */
	public Board createBoard(Board board) {
		board.setCreatedTime(new Date());
		board.setUpdatedTime(new Date());
		board.setCounts(0);
		board.setLikes(0);
		return boardRepository.save(board);
	}
	/*
	 * 글 상세보기
	 */
	public ResponseEntity<Board> getBoard(Integer no) {
		Board board = boardRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not Found Data no [" + no + "]"));
		board.setCounts(board.getCounts() + 1);
		boardRepository.save(board);
		return ResponseEntity.ok(board);
	}

	/*
	 * 글 업데이트
	 */
	public ResponseEntity<Board> updateBoard(Integer no, Board updateBoard) {
		Board board = boardRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not Found Data no [" + no + "]"));
		
		board.setType(updateBoard.getType());
		board.setTitle(updateBoard.getTitle());
		board.setContents(updateBoard.getContents());
		board.setUpdatedTime(new Date());
		
		Board endUpdateBoard = boardRepository.save(board);
		return ResponseEntity.ok(endUpdateBoard);
	}
	
	/*
	 * 글 삭제
	 */
	public ResponseEntity<Map<String, Boolean>> deleteBoard(Integer no) {
		Board board = boardRepository.findById(no).orElseThrow(() -> new ResourceNotFoundException("Not Found Data no [" + no + "]"));
		
		boardRepository.delete(board);
		Map<String, Boolean> response = new HashMap<>();
		response.put("Deleted Board Data by id : [" + no + "]", Boolean.TRUE);
		return ResponseEntity.ok(response);
	}
	

}
