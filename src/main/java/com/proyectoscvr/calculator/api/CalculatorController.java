package com.proyectoscvr.calculator.api;

import java.math.BigDecimal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.proyectoscvr.calculator.api.dto.ErrorDTO;
import com.proyectoscvr.calculator.api.dto.OperationDTO;
import com.proyectoscvr.calculator.service.ICalculatorService;
import com.proyectoscvr.calculator.tracer.TracerCalc;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * 
 * @author Carlos
 * 
 * Controlador responsable de procesar las solicitudes que recibe la API
 *
 */
@RestController
@Tag(name = "Calculator", description = "Calculator API Rest")
public class CalculatorController {

	@Autowired
	ICalculatorService calculatorService;
	
	@Autowired
    private TracerCalc tracer;

	// Metodo encargado de procesa solicitudes POST en "/api/calculate"
	@Operation(summary = "Addition or substraction of the two input values")
	@ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Result", content = { @Content(mediaType = "application/json", 
            	      schema = @Schema(implementation = BigDecimal.class)) }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = { @Content(mediaType = "application/json", 
  	      schema = @Schema(implementation = ErrorDTO.class)) }),
            @ApiResponse(responseCode = "500", description = "Internal Error", content = { @Content(mediaType = "application/json", 
  	      schema = @Schema(implementation = ErrorDTO.class)) })
	})    
	@PostMapping(value = "/api/calculate", produces = { "application/json" })
    public  ResponseEntity<BigDecimal> calculate(@Valid @RequestBody OperationDTO operation) {
		
		BigDecimal result = calculatorService.calculate(operation);
		
		tracer.trace(operation.toString() + " Result=" + result);
		
		return new ResponseEntity<>(result, HttpStatus.OK);
    }
	
}
