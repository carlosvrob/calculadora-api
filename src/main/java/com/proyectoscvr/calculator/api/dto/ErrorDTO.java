package com.proyectoscvr.calculator.api.dto;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;

import lombok.Value;

@Value
public class ErrorDTO {

	private LocalDateTime timestamp;
	private int status;
	private String error;
	private String path;
}
