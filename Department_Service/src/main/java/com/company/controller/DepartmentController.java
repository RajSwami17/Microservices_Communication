package com.company.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.model.Department;
import com.company.service.DepartmentService;

@RestController
@RequestMapping("/dept")

public class DepartmentController 
{
	@Autowired
	private DepartmentService deptService;
	
	@PostMapping("/create")
	public ResponseEntity<Department> createDepartment(@RequestBody Department dept)
	{
		Department saveDepartment = deptService.saveDepartment(dept);
		return new ResponseEntity<>(saveDepartment,HttpStatus.CREATED);
	}
	
	@GetMapping("/{deptId}")
	public ResponseEntity<Department> fetchDeptById(@PathVariable("deptId")Long deptId)
	{
		Department fetchDepartment = deptService.getDepartmentById(deptId);
		return ResponseEntity.ok(fetchDepartment);
	}
	
	@GetMapping("/")
	public ResponseEntity<List<Department>> getAllDepartments()
	{
		List<Department> allDepartments = deptService.getAllDepartments();
		return new ResponseEntity<>(allDepartments,HttpStatus.OK);
	}
}
