package com.proyectoscvr.calculator.operations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SubstractionOperation implements IOperation {

	private static final String ID = "SUB";
	
	@Override
	public BigDecimal execute(BigDecimal firstOperand, BigDecimal secondOperand) {

		return firstOperand.subtract(secondOperand);
	}

	@Override
	public String getOperationId() {
		return ID;
	}

}
