package com.vaibhav.ws.bank.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CustomExceptionHandler {

	@ExceptionHandler(value=TransactionIdNotFoundException.class)
	public ResponseEntity<Object> TransactionIdNotFoundException(TransactionIdNotFoundException ex) {
		
		ErrorResponse errorResponse = new ErrorResponse();
		
		errorResponse.setMsg(ex.getMessage());
		
		errorResponse.setTransactionid(ex.getTransactionid());
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
}
