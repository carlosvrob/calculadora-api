package com.proyectoscvr.calculator.tracer;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class TracerCalcTest {

    private static TracerCalc tracer;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		tracer = new TracerCalc();
	}

	@Test
	void testTracerMethod() {
		tracer.trace("Test unitario TracerCalc para cumplir con cobertura codigo");
	}

}
