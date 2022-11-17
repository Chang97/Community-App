package com.board.back.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.board.back.model.User;
import com.board.back.repository.UserRepository;

@Service
public class PrincipalDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if(username == null || username.equals("")) {
			throw new UsernameNotFoundException(username);
		}
		
		User user = userRepository.findByUsername(username).orElseThrow(()->{
			return new UsernameNotFoundException("해당 사용자를 찾을 수 없습니다. : "+username);
		});
		;
		return new PrincipalDetails(user);
	}

}