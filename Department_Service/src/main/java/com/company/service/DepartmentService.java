package com.company.service;

import java.util.List;

import com.company.model.Department;

public interface DepartmentService 
{

	Department saveDepartment(Department dept);
	
	Department getDepartmentById(Long deptId);
	
	List<Department> getAllDepartments();
}
