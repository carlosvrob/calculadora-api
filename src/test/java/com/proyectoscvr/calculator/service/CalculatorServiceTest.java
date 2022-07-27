package com.proyectoscvr.calculator.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.proyectoscvr.calculator.api.dto.OperationDTO;
import com.proyectoscvr.calculator.exceptions.InvalidOperationException;
import com.proyectoscvr.calculator.operations.AdditionOperation;
import com.proyectoscvr.calculator.operations.IOperation;
import com.proyectoscvr.calculator.operations.SubstractionOperation;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class CalculatorServiceTest {

	@Autowired
    private CalculatorService calculatorService;
	
	private OperationDTO operationDTO;
	
	@BeforeAll
	public void setUp() {			  
		AdditionOperation operation = new AdditionOperation();
		SubstractionOperation operation2 = new SubstractionOperation();
		
		List<IOperation> IOperationList = new ArrayList<IOperation>();
		IOperationList.add(operation);
		IOperationList.add(operation2);
		
		calculatorService.supportedOperations = IOperationList;
	}
	
	@Test
	void validAdditionOperationDTO_givesValidAdditionResult() throws InvalidOperationException {				
		operationDTO = new OperationDTO("ADD", new BigDecimal(1.0), new BigDecimal(1.0));	
		
		BigDecimal resultCalculatorService = calculatorService.calculate(operationDTO);	
		
		assertThat(new BigDecimal(2)).isEqualByComparingTo(resultCalculatorService);
	}
	
	@Test
	void validSubstractionOperationDTO_givesValidSubstractionResult() throws InvalidOperationException {				
		operationDTO = new OperationDTO("SUB", new BigDecimal(1.0), new BigDecimal(1.0));
		
		BigDecimal resultCalculatorService = calculatorService.calculate(operationDTO);			
		
		assertThat(new BigDecimal(0)).isEqualByComparingTo(resultCalculatorService);
	}

	@Test
	void invalidOperation_throwsInvalidOperationException() throws InvalidOperationException {
		String invalidOperation = "DIV";
		
		operationDTO = new OperationDTO(invalidOperation, new BigDecimal(1.0), new BigDecimal(1.0));
		
		Exception exception = assertThrows(InvalidOperationException.class, () -> {
			calculatorService.calculate(operationDTO);
	    });
		
		String expectedMessageException = "Invalid or unimplemented operation (operationType=" + invalidOperation + ")";
		
		String messageException = exception.getMessage();
		
	    assertEquals(messageException, expectedMessageException);		
	}
}
