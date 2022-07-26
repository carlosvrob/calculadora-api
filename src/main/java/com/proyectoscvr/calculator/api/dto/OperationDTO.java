package com.proyectoscvr.calculator.api.dto;

import java.math.BigDecimal;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class OperationDTO {
	
    @Schema(description = "Type of math operation. 'ADD' for addition or 'SUB' for substraction", example = "ADD", required = true)
	@NotEmpty(message = "typeOperation is required")
	private String typeOperation;
	
    @Schema(description = "First operand of math operation", example = "8", required = true)
	@NotNull(message = "firstOperand is required  and must be in numeric format")
	private BigDecimal firstOperand;
	
    @Schema(description = "Second operand of addition/substraction", example = "5", required = true)
	@NotNull(message = "secondOperand is required  and must be in numeric format")	
	private BigDecimal secondOperand;
}
