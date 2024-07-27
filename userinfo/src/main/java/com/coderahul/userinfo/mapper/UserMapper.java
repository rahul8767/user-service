package com.coderahul.userinfo.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.coderahul.userinfo.dto.UserDto;
import com.coderahul.userinfo.entity.User;

@Mapper
public interface UserMapper {

	UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
	
	User mapUserDTOToUser(UserDto userDto);
	UserDto mapUserToUserDTO(User user);
	
}
