package com.usermanagement.exceptions;

import java.util.Date;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(Exception.class)
	public ErrorDetails globalExceptionHandler(Exception e, WebRequest request) {
		ErrorDetails errorDetails = new ErrorDetails(request.getDescription(false), e.getMessage(), new Date());
		return errorDetails;
	}

}
