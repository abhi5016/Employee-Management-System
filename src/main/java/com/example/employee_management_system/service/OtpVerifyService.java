package com.example.employee_management_system.service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.employee_management_system.dto.VerifyOtpRequest;
import com.example.employee_management_system.entity.User;
import com.example.employee_management_system.exception.InvalidOtpException;
import com.example.employee_management_system.exception.OtpExpiredException;
import com.example.employee_management_system.exception.UserNotFoundException;
import com.example.employee_management_system.repository.UserRepository;

@Service
public class OtpVerifyService {

	private UserRepository userRepository;

	public OtpVerifyService(UserRepository userRepository) {

		this.userRepository = userRepository;
	}

	public String otpVerification(VerifyOtpRequest verifyOtpRequest) {

		Optional<User> op = userRepository.findByEmail(verifyOtpRequest.getEmail());
		if (op.isPresent()) {
			User user = op.get();
			if (!Objects.equals(user.getOtp(), verifyOtpRequest.getOtp())) {
//		if(!user.getOtp().equals(verifyOtpRequest.getOtp())) {
//			return "invalid otp";
				throw new InvalidOtpException("Invalid Otp");

			}
			if (LocalDateTime.now().isAfter(user.getOtpExpireyTime())) {
//			return "Otp Got Expired";
//				Optional<User>
				throw new OtpExpiredException("Otp Got Expired");

			} else {
				user.setVerified(true);
				user.setOtp(null);
				user.setOtpExpireyTime(null);
				userRepository.save(user);
				return "verifird successfully";
			}

		} else {
			throw new UserNotFoundException("User Not Found");

		}
	}
}
