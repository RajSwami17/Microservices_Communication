package com.company.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.company.dto.DepartmentDto;
import com.company.dto.ResponseDto;
import com.company.dto.UserDto;
import com.company.model.User;
import com.company.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private RestTemplate restTemplate;
 
	@Override
	public User saveUser(User user) 
	{
		return userRepo.save(user);
	}

	@Override
	public ResponseDto getUser(Long userId) 
	{
		ResponseDto responseDto = new ResponseDto();
		User user = userRepo.findById(userId).get();
		UserDto userDto = mapToUser(user);
		
		ResponseEntity<DepartmentDto> responseEntity = 
				restTemplate.getForEntity("http://localhost:8085/dept/" + user.getDeptId(), DepartmentDto.class);
		
		DepartmentDto deptDto = responseEntity.getBody();
		
		System.out.println(responseEntity.getStatusCode());
		
		responseDto.setUser(userDto);
		responseDto.setDepartment(deptDto);	
		
		return responseDto;
	}
	
	public UserDto mapToUser(User user)
	{
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setFirstName(user.getFirstName());
		userDto.setLastName(user.getLastName());
		userDto.setEmail(user.getEmail());
		return userDto;
	}
	
}
