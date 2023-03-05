package com.app.controller;

import java.util.List;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSpecificResponse;
import com.app.pojos.User;
import com.app.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {

	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	private UserService userSer;

	public UserController() {
		System.out.println("In def ctor of " + getClass());
	}

	// Request handling method for rendering login form
	@GetMapping("/login")
	public String showLoginForm() {
		System.out.println("In user show login form");
		return "";
	}

	// URL : http://host:post/users method=get
	@GetMapping
	public List<User> getUsers() {
		System.out.println("In user getUsers");
		return userSer.getAllUsersDetails();
	}

	// URL : http://host:post/users method=post
	@PostMapping("/Register")
	public UserSpecificResponse addNewUser(@RequestBody UserDto newUser) {
		System.out.println("In add new user");
		return userSer.addNewUser(newUser);
	}

	@DeleteMapping("/{userId}")
	public String deleteUser(@PathVariable Long userId) {
		System.out.println("In delete user");
		return userSer.deleteUser(userId);
	}

	@GetMapping("/{empId}")
	public User getUserDetails(@PathVariable Long userId) {
		return userSer.getUserDetails(userId);
	}

	@PutMapping
	public User updateUserDetails(@RequestBody User user) {
		System.out.println("In update user");
		user.setId(user.getId());
		return userSer.updateUserDetails(user);
	}

	@PostMapping("/login")
	public ResponseEntity<?> validateUser(@RequestBody @Valid UserLoginDto dto) {
		System.out.println("in User loginin " + dto);
		return ResponseEntity.ok(userSer.authenticateUser(dto));
	}

}
