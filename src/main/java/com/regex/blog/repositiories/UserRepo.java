package com.regex.blog.repositiories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.regex.entity.User;


@EnableJpaRepositories
public interface UserRepo extends JpaRepository<User ,Integer>{
	
	
	
}
