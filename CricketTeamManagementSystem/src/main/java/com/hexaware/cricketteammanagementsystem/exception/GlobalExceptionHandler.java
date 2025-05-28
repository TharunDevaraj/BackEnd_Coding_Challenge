package com.hexaware.cricketteammanagementsystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler({InvalidRoleException.class})
	public ResponseEntity<String> roleExceptionHandler()
	{
		return new ResponseEntity<String>("Invalid Role, Enter a valid role [Batsman, Bowler, Wicket Keeper, All Rounder]", HttpStatus.NOT_ACCEPTABLE);
	}
	
	@ExceptionHandler({PlayerNotFoundException.class})
	public ResponseEntity<String> playerExceptionHandler()
	{
		return new ResponseEntity<String>("Player Not Found ! Enter valid PlayerId", HttpStatus.NOT_FOUND);
	}

}
