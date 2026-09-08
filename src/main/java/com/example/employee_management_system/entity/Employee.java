package com.example.employee_management_system.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Entity
@Data
@Table(name = "employees")
public class Employee {
	
	@Id
	@Email
	@NotBlank(message = "must be a well formed email addresh")
	private String email;
	
	@NotBlank(message = "must not be blank")
	private String name;
	
	@Positive(message = "salary should be more than 0")
	private double salary;
	
	@NotBlank(message = "must not be blank")
	private String department;

}
