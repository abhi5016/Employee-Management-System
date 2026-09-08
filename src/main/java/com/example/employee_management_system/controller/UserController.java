package com.example.employee_management_system.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.employee_management_system.dto.RegisterRequest;
import com.example.employee_management_system.dto.ResendOtpRequest;
import com.example.employee_management_system.dto.VerifyOtpRequest;
import com.example.employee_management_system.service.OtpVerifyService;
import com.example.employee_management_system.service.ResendOtpService;
import com.example.employee_management_system.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService service;
	private OtpVerifyService otpVerifyService;
	private ResendOtpService resendOtpService;

	public UserController(UserService service, OtpVerifyService otpVerifyService, ResendOtpService resendOtpService ) {
		super();
		this.service = service;
		this.otpVerifyService = otpVerifyService;
		this.resendOtpService = resendOtpService;
	}

	@PostMapping("/register")
	public String registerRequest(@Valid @RequestBody RegisterRequest registerRequest) {
		return service.registerRequest(registerRequest);
	}

	@PostMapping("/verify-otp")
	public String otpVerification(@Valid @RequestBody VerifyOtpRequest verifyOtpRequest) {
		return otpVerifyService.otpVerification(verifyOtpRequest);

	}

	@PostMapping("/resend-otp")
	public String resendOtp(@Valid @RequestBody ResendOtpRequest resendOtpRequest) {
	    return resendOtpService.resendOtp(resendOtpRequest);
	}
}
