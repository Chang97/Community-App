package com.board.back.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.board.back.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
