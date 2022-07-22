package com.proyectoscvr.calculator.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoscvr.calculator.api.dto.OperationDTO;
import com.proyectoscvr.calculator.service.ICalculatorService;

@RestController
public class CalculatorController {

	@Autowired
	ICalculatorService calculatorService;

	@PostMapping(value = "/api/calculate", produces = { "application/json" })
    public  ResponseEntity<Double> calculate(@RequestBody OperationDTO operation) {
		
		Double result = calculatorService.calculate(operation);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
}
