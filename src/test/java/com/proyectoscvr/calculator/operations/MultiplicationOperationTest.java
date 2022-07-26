package com.proyectoscvr.calculator.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MultiplicationOperationTest {

	@Autowired
	private MultiplicationOperation multiplicationOperation;
	
	@Test
	void testMultiplicationExecuteMethod() {
		BigDecimal res = multiplicationOperation.execute(BigDecimal.valueOf(3.0), BigDecimal.valueOf(5.0));
		
		assertEquals((BigDecimal.valueOf(3.0).multiply(BigDecimal.valueOf(5.0))), res);
	}
	
	@Test
	void testAdditionOperationIdMethod() {
		String id = multiplicationOperation.getOperationId();
		
		assertEquals("MUL", id);
	}
}
