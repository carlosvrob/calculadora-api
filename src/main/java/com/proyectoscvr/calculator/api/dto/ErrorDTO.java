package com.proyectoscvr.calculator.api.dto;

import java.time.LocalDateTime;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Value;

@Value
public class ErrorDTO {

    @Schema(description = "Timestamp when error occurred", example = "2022-07-24T19:30:15.350742")
	private LocalDateTime timestamp;
    
    @Schema(description = "HTTP Status code", example = "400")
	private int status;
    
    @Schema(description = "Information about error", example = "First name must be 'ADD' or 'SUB'")
	private String error;
    
    @Schema(description = "Path error", example = "/api/calculate")
	private String path;
}
