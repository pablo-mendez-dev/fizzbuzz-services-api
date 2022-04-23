package com.intraway.fizzbuzz.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.intraway.fizzbuzz.exceptions.AppBussinesException;

@ControllerAdvice()
public class ExceptionsControllerAdvice {

	/**
	 * ExceptionHandler de la excepcion personalizada AppBussinesException
	 * @param AppBussinesException
	 * @return ResponseEntity
	 * 
	 */
	@ExceptionHandler(AppBussinesException.class)
	private ResponseEntity<Object> generateResponse(com.intraway.fizzbuzz.exceptions.AppBussinesException ex) {
		return new ResponseEntity<>("Runtime Exception, Message: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
