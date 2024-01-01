package com.company.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.model.Department;
import com.company.repo.DepartmentRepo;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService 
{
	@Autowired
	private DepartmentRepo deptRepo;
	
	@Override
	public Department saveDepartment(Department dept) 
	{
		return deptRepo.save(dept);
	}

	@Override
	public Department getDepartmentById(Long deptId) 
	{
		return deptRepo.findById(deptId).get();
	}

	@Override
	public List<Department> getAllDepartments() 
	{
		List<Department> allDepartment = deptRepo.findAll();
		return allDepartment;
	}
}
