package com.irctc.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceNotFoundException {
	@ExceptionHandler(value = ResourceNotFound.class)
	   public ResponseEntity<Object> exception(ResourceNotFound exception) {
	      return new ResponseEntity<>("Product not found", HttpStatus.NOT_FOUND);
	   }
}
