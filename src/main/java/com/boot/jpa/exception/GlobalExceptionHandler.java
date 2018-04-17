package com.boot.jpa.exception;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {
	@ExceptionHandler(AccountNotFoundException.class)
	protected ResponseEntity<Object> handleAccountNotFound() {
		ApiError apiError = new ApiError();
		apiError.setMessage("Account Not Found");
		apiError.setStatus(HttpStatus.NOT_FOUND);
		return buildResponseEntity(apiError);
	}
	
	@ExceptionHandler(EmptyResultDataAccessException.class)
	protected ResponseEntity<Object> handleDataNotFound(){
		ApiError apiError = new ApiError();
		apiError.setMessage("No data exist");
		apiError.setStatus(HttpStatus.NOT_FOUND);
		return buildResponseEntity(apiError);
	}
	
	private ResponseEntity<Object> buildResponseEntity(ApiError apiError) {
		return new ResponseEntity<>(apiError, apiError.getStatus());
	}
}

class ApiError {
	private String message;
	private HttpStatus status;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}
}
