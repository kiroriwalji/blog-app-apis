package com.regex.blog.services;
import java.util.List;

import org.springframework.stereotype.Service;

import com.regex.blog.payloads.UserDto;
	
@Service
	public interface UserService {
		
		UserDto registerNewUser(UserDto userDto);
		UserDto createUser(UserDto userDto);
		UserDto updateUser(UserDto userDto, Integer userId);
		UserDto getUserById(Integer userId);
		List<UserDto> getAllUsers();
		void deleteUser(Integer userId);
//		UserDto createUser(UserDto userDto);
		UserDto createUserDto(UserDto userDto);
		
	}
	
