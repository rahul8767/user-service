package com.coderahul.userinfo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.coderahul.userinfo.dto.UserDto;
import com.coderahul.userinfo.entity.User;
import com.coderahul.userinfo.mapper.UserMapper;
import com.coderahul.userinfo.repo.UserRepo;


@Service
public class UserService {

	@Autowired
	UserRepo userRepo;

	public UserDto addUser(UserDto userDTO) {
		// TODO Auto-generated method stub
		User savedUser = userRepo.save(UserMapper.INSTANCE.mapUserDTOToUser(userDTO));
		
		return UserMapper.INSTANCE.mapUserToUserDTO(savedUser);
	
	}

	public ResponseEntity<UserDto> fetchUserDetailsById(Integer userId) {
		// TODO Auto-generated method stub
		Optional<User> fetchedUser =userRepo.findById(userId);
		if(fetchedUser.isPresent())
			return new ResponseEntity<>(UserMapper.INSTANCE.mapUserToUserDTO(fetchedUser.get()), HttpStatus.OK);
		return  new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
		
	}
}
