package com.board.back.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.board.back.dto.UserDTO;
import com.board.back.model.User;
import com.board.back.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/auth")
public class UserContoller {

	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public User createUser(@RequestBody UserDTO dto) {
		// 패스워드 암호화
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		dto.setPassword(passwordEncoder.encode(dto.getPassword()));
		// 권한설정 (일반회원)
		dto.setRole("USER");
		
		return userService.createBoard(dto);
	}
	
	@GetMapping("/login")
	public String loginForm() {

		return "/join";
	}
	
}
