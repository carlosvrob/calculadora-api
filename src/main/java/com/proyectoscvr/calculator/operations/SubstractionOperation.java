package com.proyectoscvr.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class SubstractionOperation implements IOperation {

	@Override
	public Double execute(Double operandA, Double operandB) {

		return operandA - operandB ;
	}

}
