package com.proyectoscvr.calculator.service;

import java.math.BigDecimal;

import com.proyectoscvr.calculator.api.dto.OperationDTO;

public interface ICalculatorService {

	BigDecimal calculate(OperationDTO operation);

}
