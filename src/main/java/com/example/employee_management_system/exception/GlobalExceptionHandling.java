package com.example.employee_management_system.exception;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandling {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> invalidData(MethodArgumentNotValidException exception) {
		Map<String, String> map = new HashMap<String, String>();
		List<FieldError> fe = exception.getBindingResult().getFieldErrors();

		for (FieldError e : fe) {
			map.put(e.getField(), e.getDefaultMessage());
		}
		return new ResponseEntity<Map<String, String>>(map, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<String> userNotEntity(UserNotFoundException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidOtpException.class)
	public ResponseEntity<String> invalidOtp(InvalidOtpException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(OtpExpiredException.class)
	public ResponseEntity<String> otpExpired(OtpExpiredException exception) {
		return new ResponseEntity<String>(exception.getMessage(), HttpStatus.BAD_GATEWAY);
	}

}
