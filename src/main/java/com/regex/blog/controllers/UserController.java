package com.regex.blog.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.regex.blog.payloads.ApiResponse;
import com.regex.blog.payloads.UserDto;
import com.regex.blog.services.UserService;




@RestController
@RequestMapping("/api/users")

public class UserController {
	
	private UserService userService;
	public UserController(UserService userService) {
        this.userService = userService;
    }
	//POST - create user
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto){
		UserDto createUserDto = this.userService.createUser(userDto);
		return new ResponseEntity<>(createUserDto, HttpStatus.CREATED);
	}

	//put - update user
	// @PutMapping("/{userId}")
	// public ResponseEntity<UserDto> updatedUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
	// 	UserDto updatedUser = this.userService.updateUser(userDto, userId);
	// 	return ResponseEntity.ok(updatedUser);
	// }
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updatedUser(@RequestBody UserDto userDto,@PathVariable Integer userId){
		UserDto updatedUser = this.userService.updateUser(userDto, userId);
		return ResponseEntity.ok(updatedUser);
	}



	// Delete - delete user
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUser(@PathVariable Integer userId){
		this.userService.deleteUser(userId);
		return new ResponseEntity<ApiResponse>(new ApiResponse("User Deleted Successfully", true),HttpStatus.OK);
	}

	//Get - user get
    @GetMapping()
	public ResponseEntity<List<UserDto>> getAllUsers(){
		return ResponseEntity.ok(this.userService.getAllUsers());
	}

	// get nsingle user

	@GetMapping("/api/users/{userId}")
    public ResponseEntity<UserDto> getSingleUser(@PathVariable Integer userId){
		return ResponseEntity.ok(this.userService.getUserById(userId));
	}
	

}
