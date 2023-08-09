package com.example.handler;

import org.springframework.http.HttpStatus;	
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.exception.CallException;
import com.example.ui.ErrorResponseModel;

@ControllerAdvice
public class DoctorExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ErrorResponseModel> handleUserNotFoundException(CallException e)
	{
		ErrorResponseModel model=new ErrorResponseModel(e.getMessage(), System.currentTimeMillis(), HttpStatus.FOUND.ordinal());
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(model);
	}

}