package com.example.controller;

import com.example.model.UserException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;


public class CommonController {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<String> handleException(Exception ex) {
		ex.printStackTrace();
		if (ex instanceof UserException) {
			return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
		}
		if (ex instanceof AccessDeniedException) {
			return new ResponseEntity<>("access_denied", HttpStatus.UNAUTHORIZED);
		}
		return new ResponseEntity<>("unknown_error", HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
