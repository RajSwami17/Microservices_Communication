package com.company.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="Department_Details")
@Data
public class Department 
{
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="Dept_Id")
	private Long id;
	
	@Column(name="Dept_Name")
	private String deptName;
	
	@Column(name="Dept_Address")
	private String deptAddress;
	
	@Column(name="Dept_Code")
	private String deptCode;
	
	
}
