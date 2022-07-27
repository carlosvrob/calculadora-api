package com.proyectoscvr.calculator.exceptions;

import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.proyectoscvr.calculator.api.dto.ErrorDTO;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
class ExceptionHandlerControllerTest {
	
	private ExceptionHandlerController exceptionHandlerController;

	private MockHttpServletRequest req;

	private String expectedRequestURI = "unitTestCaseURI";
	private String expectedErrorMessage = "unitTestCaseError";
	private LocalDateTime expectedTimestamp;
	
	@BeforeAll
	public void setUp() {
		exceptionHandlerController = new ExceptionHandlerController();
		
		req = new MockHttpServletRequest();
		req.setRequestURI(expectedRequestURI);
		RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(req));
		
		expectedTimestamp = LocalDateTime.now();
	}
	
	@Test
	void handleMethodArgumentNotValidExceptionMethodTest() {						
		// BeanPropertyBindingResult implementa BindingResult
		BeanPropertyBindingResult bindingResult = new BeanPropertyBindingResult(new Object(), "target");
		
		// Creamos un error para el Test case
		ObjectError err = new ObjectError("unitTestCaseError", expectedErrorMessage);
		bindingResult.addError(err);
		
		MethodArgumentNotValidException methodArgumentNotValidException = new MethodArgumentNotValidException(null, bindingResult);
		
		ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleMethodArgumentNotValidException(methodArgumentNotValidException, req);
		
		assertAll(
				"errorDTO",
				() -> assertTrue((expectedTimestamp.isBefore(response.getBody().getTimestamp()) || (expectedTimestamp.isEqual(response.getBody().getTimestamp())))),
				() -> assertEquals(HttpStatus.BAD_REQUEST.value(), response.getBody().getStatus()),
				() -> assertEquals(expectedRequestURI, response.getBody().getPath()),
				() -> assertEquals(expectedErrorMessage, response.getBody().getError())
		);
	}
		
	@Test
	void handleInvalidFormatExceptionMethodTest() {
		JsonParser p = null;
		
		String value = "133abc";
		String classExpected = "java.math.BigDecimal";
		
		InvalidFormatException invalidFormatException = new InvalidFormatException(p,
				"", value, java.math.BigDecimal.class);
			
		ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleInvalidFormatException(invalidFormatException, req);
			
		assertAll(
				"errorDTO",
				() -> assertEquals(HttpStatus.BAD_REQUEST.value(), response.getBody().getStatus()),
				() -> assertEquals(expectedRequestURI, response.getBody().getPath()),
				() -> org.hamcrest.MatcherAssert.assertThat(response.getBody().getError(), containsString(value)),
				() -> org.hamcrest.MatcherAssert.assertThat(response.getBody().getError(), containsString(classExpected))
		);
		
	}

	@Test
	void handleInvalidOperationExceptionMethodTest() {
		InvalidOperationException invalidOperationException = new InvalidOperationException(expectedErrorMessage);
			
		ResponseEntity<ErrorDTO> response = exceptionHandlerController.handleInvalidOperationException(invalidOperationException, req);
			
		assertAll(
				"errorDTO",
				() -> assertEquals(HttpStatus.NOT_FOUND.value(), response.getBody().getStatus()),
				() -> assertEquals(expectedRequestURI, response.getBody().getPath()),
				() -> assertEquals(expectedErrorMessage, response.getBody().getError())
		);
		
	}

}
