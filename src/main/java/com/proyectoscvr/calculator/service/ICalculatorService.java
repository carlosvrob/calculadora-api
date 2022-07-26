package com.proyectoscvr.calculator.service;

import java.math.BigDecimal;

import com.proyectoscvr.calculator.api.dto.OperationDTO;
import com.proyectoscvr.calculator.exceptions.InvalidOperationException;

public interface ICalculatorService {

	BigDecimal calculate(OperationDTO operation) throws InvalidOperationException;

}
