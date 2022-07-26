package com.proyectoscvr.calculator.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SubstractionOperationTest {

	@Autowired
	private SubstractionOperation substractionOperation;
	
	@Test
	void testSubstractionExecuteMethod() {
		BigDecimal res = substractionOperation.execute(BigDecimal.valueOf(3.0), BigDecimal.valueOf(5.0));
		
		assertEquals(BigDecimal.valueOf(3.0).subtract(BigDecimal.valueOf(5.0)), res);
	}
	
	@Test
	void testSubstractionOperationIdMethod() {
		String id = substractionOperation.getOperationId();
		
		assertEquals("SUB", id);
	}
}
