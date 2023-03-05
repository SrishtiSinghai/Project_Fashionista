package com.app.service;

import java.io.IOException;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.app.dto.ApiResponse;
import com.app.dto.UserDto;
import com.app.dto.UserLoginDto;
import com.app.dto.UserSpecificResponse;
import com.app.exception.ResourceNotFoundException;
import com.app.pojos.User;
import com.app.repository.UserRepository;

@Service
@Transactional
public class UserServiceImpl implements UserService{

	@Autowired
	private UserRepository userRepo;
	
	@Autowired
	private ModelMapper mapper;

	@Override
	public List<User> getAllUsersDetails() {
		return userRepo.findAll();
	}


	@Override
	public String deleteUser(Long userId) {
		String mesg = "delete user failed...";
		if(userRepo.existsById(userId))
		{
			userRepo.deleteById(userId);
			mesg = "User deleted successfully...";
		}
		return mesg;
	}

	@Override
	public User getUserDetails(Long userId) {
		return userRepo.findById(userId).orElseThrow(()->new ResourceNotFoundException("Invalid user id... Plz try again"));
	}

	@Override
	public User updateUserDetails(User user) {
		if(userRepo.existsById(user.getId())) {
			System.out.println("In service update user");
			return userRepo.save(user);
		}
		throw new ResourceNotFoundException("User record not exists...");
	}

	@Override
	public UserSpecificResponse authenticateUser(UserLoginDto dto) {
		// TODO Auto-generated method stub
		
		User user = userRepo.findByEmailAndPassword(dto.getEmail(), dto.getPassword())
				.orElseThrow(() -> new ResourceNotFoundException("Bad Credentials !!!!!"));
		return mapper.map(user, UserSpecificResponse.class);
	}

	@Override
	public UserSpecificResponse addNewUser(UserDto user) {
		// TODO Auto-generated method stub
		User newUser = mapper.map(user, User.class);
		User cust = userRepo.save(newUser);
		
		return mapper.map(cust, UserSpecificResponse.class);
	}
	
	

	
	
}
