package com.proyectoscvr.calculator.operations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AdditionOperationTest {

	@Autowired
	private AdditionOperation additionOperation;
	
	@Test
	void testAdditionExecuteMethod() {
		Double res = additionOperation.execute(3.0, 5.0);
		
		assertEquals(8.0, res);
	}
}
