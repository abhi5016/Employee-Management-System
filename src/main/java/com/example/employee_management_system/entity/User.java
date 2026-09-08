package com.example.employee_management_system.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Entity
@Table(name = "users")
@Data
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotBlank(message = "Name is mandatory")
	private String name;
	
	@Email
	@NotBlank(message = "Email should be valid")
	private String email;
	
	@Min(value = 6, message = "Password should have at least 6 characters")
	private String password;
	private String role;
	private boolean verified;
	private String otp;
	private LocalDateTime otpExpireyTime;
	

}
