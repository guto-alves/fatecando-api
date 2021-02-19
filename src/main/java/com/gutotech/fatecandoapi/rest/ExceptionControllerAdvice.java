package com.gutotech.fatecandoapi.rest;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice {

	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ErrorResponse> resourceNotFoundHandler(ResourceNotFoundException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse( //
				System.currentTimeMillis(), //
				HttpStatus.NOT_FOUND.value(), //
				HttpStatus.NOT_FOUND.getReasonPhrase(), //
				ex.getMessage(), //
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND) //
				.body(errorResponse);
	}
}
