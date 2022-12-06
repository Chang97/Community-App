package com.board.back.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.board.back.model.Menu;
import com.board.back.repository.MenuRepository;

@Service
public class MenuService {
	
	@Autowired
	private MenuRepository menuRepository;

	public List<Menu> getAllMenus() {
		
		return menuRepository.findAll();
	}

}
