package com.proyectoscvr.calculator.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.proyectoscvr.calculator.api.CalculatorController;
import com.proyectoscvr.calculator.api.dto.OperationDTO;
import com.proyectoscvr.calculator.exceptions.InvalidOperationException;
import com.proyectoscvr.calculator.service.CalculatorService;
import com.proyectoscvr.calculator.tracer.TracerCalc;

@SpringBootTest
class CalculatorControllerTest {

	@InjectMocks
	CalculatorController calculatorController;
	
	@Mock
	CalculatorService calculatorService;
	
	@Mock
    private TracerCalc tracer;
	
	private BigDecimal expectedValue = new BigDecimal(12345);
	
	OperationDTO operationDTO;

	@Test
	void calculateMethodTest() throws InvalidOperationException {
		MockHttpServletRequest req = new MockHttpServletRequest();
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));			
		
		Mockito.when(calculatorService.calculate(any(OperationDTO.class))).thenReturn(expectedValue);
		
		operationDTO = new OperationDTO("ADD", new BigDecimal(3), new BigDecimal(5));
		
		ResponseEntity<BigDecimal> response = calculatorController.calculate(operationDTO);
		
		assertEquals(HttpStatus.OK, response.getStatusCode());
		assertEquals(expectedValue, response.getBody());
	}

}
