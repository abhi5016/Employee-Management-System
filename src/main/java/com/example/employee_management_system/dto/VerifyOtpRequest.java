package com.example.employee_management_system.dto;

import lombok.Data;

@Data
public class VerifyOtpRequest {
	
	private String email;
	private String otp;

}
