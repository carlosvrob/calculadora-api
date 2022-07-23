package com.proyectoscvr.calculator.api;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.proyectoscvr.calculator.api.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionHandlerController{

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
		ErrorDTO result = new ErrorDTO(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), e.getMessage(), request.getRequestURI());
			
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<ErrorDTO> handleRuntimeException(RuntimeException e, HttpServletRequest request) {
		ErrorDTO result = new ErrorDTO(LocalDateTime.now(), HttpStatus.INTERNAL_SERVER_ERROR.value(), e.getMessage(), request.getRequestURI());
		
		return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
