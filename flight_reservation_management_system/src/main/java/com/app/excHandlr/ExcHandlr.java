package com.app.excHandlr;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.app.dto.ErrorResponse;
import com.app.exceptions.UserHandlingException;

public class ExcHandlr extends ResponseEntityExceptionHandler {
	@ExceptionHandler({UserHandlingException.class})
	ResponseEntity<?> handleUserHandlingException(UserHandlingException e){
		System.out.println("in user exc handler "+getClass().getName());
		return new ResponseEntity<>(new ErrorResponse(e.getMessage(), "details"), HttpStatus.UNAUTHORIZED);
	}
	
	
	
}
