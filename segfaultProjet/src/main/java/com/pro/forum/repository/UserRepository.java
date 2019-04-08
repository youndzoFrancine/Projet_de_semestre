package com.pro.forum.repository;

import com.pro.forum.model.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
	
	User findById(long id);
}