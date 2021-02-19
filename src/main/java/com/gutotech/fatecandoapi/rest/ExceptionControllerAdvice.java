package com.gutotech.fatecandoapi.rest;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionControllerAdvice extends ResponseEntityExceptionHandler {

	// Error handle for @Valid
	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		List<String> errors = ex.getBindingResult() //
				.getFieldErrors() //
				.stream() //
				.map(x -> x.getDefaultMessage()) //
				.collect(Collectors.toList());

		ErrorResponse errorResponse = new ErrorResponse( //
				new Date(), //
				status.value(), //
				status.getReasonPhrase(), //
				errors, //
				ex.getMessage(), //
				request.getContextPath());

		return ResponseEntity.status(status).body(errorResponse);
	}

	@ExceptionHandler(ResourceNotFoundException.class)
	ResponseEntity<ErrorResponse> handleResourceNotFound(ResourceNotFoundException ex, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse( //
				new Date(), //
				HttpStatus.NOT_FOUND.value(), //
				HttpStatus.NOT_FOUND.getReasonPhrase(), //
				ex.getMessage(), //
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.NOT_FOUND) //
				.body(errorResponse);
	}

	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleExceptions(Exception exception, HttpServletRequest request) {
		ErrorResponse errorResponse = new ErrorResponse( //
				new Date(), //
				HttpStatus.BAD_REQUEST.value(), //
				HttpStatus.BAD_REQUEST.getReasonPhrase(), //
				exception.getMessage(), //
				request.getRequestURI());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

}
