package com.proyectoscvr.calculator.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Value;

@Value
public class OperationDTO {
	
	@NotEmpty(message = "first name must be 'ADD' or 'SUB'")
	private String typeOperation;
	
	@NotNull(message = "firstOperand is mandatory")
	private BigDecimal firstOperand;
	
	@NotNull(message = "secondOperand is mandatory")	
	private BigDecimal secondOperand;
}
