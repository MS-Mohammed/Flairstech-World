package com.flair.world.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.flair.world.exception.support.CodeNotFoundException;

@ControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

	public ApiExceptionHandler() {
		// TODO Auto-generated constructor stub
	}
	
	@ExceptionHandler(CodeNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleApiExceptions(CodeNotFoundException ex){
        ErrorResponse errorResponse = new ErrorResponse(ex.getMessage());
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
