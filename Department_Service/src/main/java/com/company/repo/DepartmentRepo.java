package com.company.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.model.Department;

public interface DepartmentRepo extends JpaRepository<Department,Long>
{

}
