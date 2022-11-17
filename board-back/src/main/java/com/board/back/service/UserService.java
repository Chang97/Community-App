package com.board.back.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.board.back.dto.UserDTO;
import com.board.back.model.User;
import com.board.back.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Transactional
	public User createBoard(UserDTO dto) {
		User user = User.builder()
				.username(dto.getUsername())
				.email(dto.getEmail())
				.password(dto.getPassword())
				.role(dto.getRole())
				.build();
		return userRepository.save(user);
	}
}