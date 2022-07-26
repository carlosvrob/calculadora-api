package com.proyectoscvr.calculator.exceptions;

import java.time.LocalDateTime;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.proyectoscvr.calculator.api.dto.ErrorDTO;

@RestControllerAdvice
public class ExceptionHandlerController{

	// Se lanza cuando no se cumplen las validaciones establecidas para la clase OperationDTO.
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		StringBuilder errorStringBuilder = new StringBuilder();
		for(ObjectError error : e.getBindingResult().getAllErrors()) {
			errorStringBuilder.append(error.getDefaultMessage());	
		}
		
		if(errorStringBuilder.isEmpty()) errorStringBuilder.append(e.getMessage());
		
		ErrorDTO result = new ErrorDTO(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), errorStringBuilder.toString(), request.getRequestURI());
			
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
	// Se lanza cuando se produce un error al convertir de String a otra clase. Por ejemplo cuando firstOperand o secondOperand no tienen un formato numérico.
	@ExceptionHandler(InvalidFormatException.class)
	public ResponseEntity<ErrorDTO> handleInvalidFormatException(InvalidFormatException e, HttpServletRequest request) {
		
		String errorMessage = "Cannot deserialize value of type " + e.getTargetType() + " from String '" +e.getValue().toString() + "'";
		
		ErrorDTO result = new ErrorDTO(LocalDateTime.now(), HttpStatus.BAD_REQUEST.value(), errorMessage, request.getRequestURI());
		
		return new ResponseEntity<>(result, HttpStatus.BAD_REQUEST);
	}
	
	// Se lanza cuando el tipo de operacion es desconocido (Operacion no valida/no implementada).
	@ExceptionHandler(InvalidOperationException.class)
	public ResponseEntity<ErrorDTO> handleInvalidOperationException(InvalidOperationException e, HttpServletRequest request) {
		ErrorDTO result = new ErrorDTO(LocalDateTime.now(), HttpStatus.NOT_FOUND.value(), e.getLocalizedMessage(), request.getRequestURI());
		
		return new ResponseEntity<>(result, HttpStatus.NOT_FOUND);
	}
}
