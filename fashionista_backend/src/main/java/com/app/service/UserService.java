package com.app.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSpecificResponse;
import com.app.pojos.User;

public interface UserService {

	List<User> getAllUsersDetails();
	
	UserSpecificResponse addNewUser(UserDto user);
	
	String deleteUser(Long userId);
	
	User getUserDetails(Long userId);
	
	User updateUserDetails(User user);
	
	UserSpecificResponse authenticateUser(UserLoginDto dto);
	
}
