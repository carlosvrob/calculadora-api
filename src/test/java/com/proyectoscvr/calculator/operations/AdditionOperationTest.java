package com.proyectoscvr.calculator.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdditionOperationTest {

	@Autowired
	private AdditionOperation additionOperation;
	
	@Test
	void testAdditionExecuteMethod() {
		BigDecimal res = additionOperation.execute(BigDecimal.valueOf(3.0), BigDecimal.valueOf(5.0));
		
		assertEquals(BigDecimal.valueOf(8.0), res);
	}
}
