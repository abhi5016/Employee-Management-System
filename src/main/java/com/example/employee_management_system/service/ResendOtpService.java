package com.example.employee_management_system.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee_management_system.dto.ResendOtpRequest;
import com.example.employee_management_system.entity.User;
import com.example.employee_management_system.exception.UserNotFoundException;
import com.example.employee_management_system.repository.UserRepository;
import com.example.employee_management_system.util.OtpGenerator;

@Service
public class ResendOtpService {

	private final UserRepository userRepository;
	private final EmailService emailService;

	public ResendOtpService(UserRepository userRepository, EmailService emailService) {
		this.userRepository = userRepository;
		this.emailService = emailService;
	}

	public String resendOtp(ResendOtpRequest resendOtpRequest) {

		Optional<User> optionalUser = userRepository.findByEmail(resendOtpRequest.getEmail());

		if (optionalUser.isEmpty()) {
			throw new UserNotFoundException("User Not Found");
		}

		User user = optionalUser.get();

		if (user.isVerified()) {
			return "User is already verified";
		}

		String otp = OtpGenerator.generateOtp();

		user.setOtp(otp);

		user.setOtpExpireyTime(LocalDateTime.now().plusMinutes(1));

		userRepository.save(user);

		emailService.sendOtp(user.getEmail(), otp);

		return "OTP resent successfully";
	}
}