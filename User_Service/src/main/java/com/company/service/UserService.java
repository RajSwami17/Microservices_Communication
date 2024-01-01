package com.company.service;

import com.company.dto.ResponseDto;
import com.company.model.User;

public interface UserService 
{
	User saveUser(User user);
	
	ResponseDto getUser(Long userId);
	
}
