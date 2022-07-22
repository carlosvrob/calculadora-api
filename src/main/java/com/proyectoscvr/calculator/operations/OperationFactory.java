package com.proyectoscvr.calculator.operations;

import org.springframework.stereotype.Component;

@Component
public class OperationFactory {

	public IOperation getOperation(String typeOperation) {
		switch(typeOperation) {
			case "ADD": return new AdditionOperation();
			
			case "SUB": return new SubstractionOperation();
			
			default: throw new IllegalArgumentException();
		}
	}
}
