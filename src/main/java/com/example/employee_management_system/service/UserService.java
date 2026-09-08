package com.example.employee_management_system.service;

import java.time.LocalDateTime;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.employee_management_system.dto.RegisterRequest;
import com.example.employee_management_system.entity.User;
import com.example.employee_management_system.repository.UserRepository;
import com.example.employee_management_system.util.OtpGenerator;

@Service
public class UserService {
	
	private UserRepository userRepository;
	private EmailService emilService;
	
	public UserService(UserRepository userRepository, EmailService emilService) {
		this.userRepository = userRepository;
		this.emilService = emilService;
	}



	public String registerRequest(RegisterRequest registerRequest) {
		Optional<User> ou = userRepository.findByEmail(registerRequest.getEmail());
		if(ou.isPresent()) {
			return "Email already exists";
		}else {
			User user = new User();
			user.setName(registerRequest.getName());
			user.setEmail(registerRequest.getEmail());
			user.setPassword(registerRequest.getPassword());
			user.setRole("Role_USER");
			user.setVerified(false);
			
			String otp= OtpGenerator.generateOtp();
			user.setOtp(otp);
			
			user.setOtpExpireyTime(LocalDateTime.now().plusMinutes(1));
			
			userRepository.save(user);
			
			emilService.sendOtp(registerRequest.getEmail(), otp);
			return "Otp Sent successfully";
		}
	}

}
