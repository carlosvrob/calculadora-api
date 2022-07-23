package com.proyectoscvr.calculator.operations;

import java.math.BigDecimal;

import org.springframework.stereotype.Component;

@Component
public class SubstractionOperation implements IOperation {

	@Override
	public BigDecimal execute(BigDecimal firstOperand, BigDecimal secondOperand) {

		return firstOperand.subtract(secondOperand);
	}

}
