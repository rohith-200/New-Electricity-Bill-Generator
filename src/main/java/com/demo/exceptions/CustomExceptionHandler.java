package com.demo.exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


@ControllerAdvice
@RestController
public class CustomExceptionHandler {

	@ExceptionHandler(BillNotFoundException.class)
	public final ResponseEntity<Error> handleBillNotFoundException(BillNotFoundException billNotFoundException){
		Error error = new Error(billNotFoundException.getMessage());
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(ConsumerNotFoundException.class)
	public final ResponseEntity<Error> handleConsumerNotFoundException(ConsumerNotFoundException consumerNotFoundException){
		Error error = new Error(consumerNotFoundException.getMessage());
		return new ResponseEntity<Error>(error,HttpStatus.NOT_FOUND);
		
	}
	
	@ExceptionHandler(AdminNotFoundException.class)
	public final ResponseEntity<Error> handleAdminNotFoundExeption(AdminNotFoundException adminNotFoundException){
		
		Error error = new Error(adminNotFoundException.getMessage());
		return new ResponseEntity<Error>(error,HttpStatus.UNAUTHORIZED);
		
	}
}
