package com.proyectoscvr.calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest
class CalculatorApplicationTests {
	
	@Autowired
    ApplicationContext context;
	
	@Test
	void contextLoads() {
		CalculatorApplication.main(new String[] {"test1", "test2"});
        assertThat(context).isNotNull();
	}

}
