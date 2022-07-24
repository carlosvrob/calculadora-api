package com.proyectoscvr.calculator.tracer;

import org.springframework.stereotype.Component;

import io.corp.calculator.TracerAPI;
import io.corp.calculator.TracerImpl;

/**
 * 
 * @author Carlos
 * 
 * Clase que implementa la TracerAPI
 *
 */
@Component
public class TracerCalc implements TracerAPI{

	private TracerImpl tracerImpl;
	
	public TracerCalc() {
		tracerImpl = new TracerImpl();
	}
	
	@Override
	public <T> void trace(T arg0) {
		tracerImpl.trace(arg0);		
	}

}
