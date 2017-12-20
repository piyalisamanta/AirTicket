package com.example.demo.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.exception.DemoServiceException;
import com.example.demo.exception.response.DemoExceptionResponse;

@ControllerAdvice
public class DemoExceptionHandler {
	
	@ExceptionHandler(DemoServiceException.class)
	public ResponseEntity<DemoExceptionResponse> handleResponseException(DemoServiceException ex){
		
		DemoExceptionResponse response = new DemoExceptionResponse();
		response.setErrorMessage(ex.getMessage());
		response.setStatus("0");;
		return new ResponseEntity<DemoExceptionResponse>(response,HttpStatus.NOT_FOUND);
		
	}

}
