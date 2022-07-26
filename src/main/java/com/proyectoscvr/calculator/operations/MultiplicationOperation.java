package com.proyectoscvr.calculator.operations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class MultiplicationOperation implements IOperation{

	private static final String ID = "MUL";
	
	@Override
	public BigDecimal execute(BigDecimal firstOperand, BigDecimal secondOperand) {

		return firstOperand.multiply(secondOperand);
	}

	@Override
	public String getOperationId() {
		return ID;
	}

}
