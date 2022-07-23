package com.proyectoscvr.calculator.service;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoscvr.calculator.api.dto.OperationDTO;
import com.proyectoscvr.calculator.operations.OperationFactory;

@Service
public class CalculatorService implements ICalculatorService{

	@Autowired
	private OperationFactory operationFactory;
	
	@Override
	public BigDecimal calculate(OperationDTO operation) {

		return operationFactory.getOperation(operation.getTypeOperation()).execute(operation.getFirstOperand(), operation.getSecondOperand());

	}

}
