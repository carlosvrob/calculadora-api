package com.proyectoscvr.calculator.operations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public interface IOperation {
	
	public String getOperationId();

	public BigDecimal execute(BigDecimal operandA, BigDecimal operandB);

}
