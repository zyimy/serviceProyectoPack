package com.restaurante.config.exception;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;


import com.restaurante.config.BadRequestException;

@ControllerAdvice(annotations = RestController.class)
public class RestauranteExceptionConfig {
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<?>notFoundException(Exception e){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
	}
	
	
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<?>badRequestException(Exception e){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
	}
	
	
	

}
