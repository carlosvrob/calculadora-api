package com.proyectoscvr.calculator.operations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class AdditionOperation implements IOperation {

	private static final String ID = "ADD";
	
	@Override
	public BigDecimal execute(BigDecimal firstOperand, BigDecimal secondOperand) {

		return firstOperand.add(secondOperand);
	}

	@Override
	public String getOperationId() {
		return ID;
	}

}
