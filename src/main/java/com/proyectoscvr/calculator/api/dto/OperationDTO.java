package com.proyectoscvr.calculator.api.dto;

import lombok.Value;

@Value
public class OperationDTO {

	private String typeOperation;
	
	private Double operandA;
	
	private Double operandB;
}
