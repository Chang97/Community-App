package com.board.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.dto.UserDTO;
import com.board.back.model.User;
import com.board.back.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/auth")
public class UserContoller {

	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public User createUser(UserDTO dto) {
		return userService.createBoard(dto);
	}
}
