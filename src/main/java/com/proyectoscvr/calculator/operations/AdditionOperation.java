package com.proyectoscvr.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class AdditionOperation implements IOperation {

	@Override
	public Double execute(Double operandA, Double operandB) {

		return operandA + operandB ;
	}

}
