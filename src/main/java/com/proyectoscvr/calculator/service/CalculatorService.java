package com.proyectoscvr.calculator.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.proyectoscvr.calculator.api.dto.OperationDTO;
import com.proyectoscvr.calculator.exceptions.InvalidOperationException;
import com.proyectoscvr.calculator.operations.IOperation;

@Service
public class CalculatorService implements ICalculatorService{
	
	@Autowired 
	List<IOperation> supportedOperations;
	
	@Override
	public BigDecimal calculate(OperationDTO operation) throws InvalidOperationException {
		
		for(IOperation o : supportedOperations) {
			if(o.getOperationId().equals(operation.getTypeOperation())) {
				return o.execute(operation.getFirstOperand(), operation.getSecondOperand());
			}
		}
		// Lista de IOperation recorrida sin encontrar la operacion solicitada. Lanzamos excepcion de operacion no implementada.
		throw new InvalidOperationException("Invalid or unimplemented operation (operationType=" + operation.getTypeOperation() + ")");
	}

}
