package com.sinensia.polloschicharron.presentation.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;

public abstract class AbstractControllerTest {

	@Autowired
	protected MockMvc mockMvc;
	
	@Autowired
	protected ObjectMapper mapper; // Para convertir de JSON a Java y de Java a JSON (El JSON es un String)
	
	protected void testResponseBody(MvcResult result, Object object) throws Exception {
		
		String responseBody = result.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String familiasAsJSON = mapper.writeValueAsString(object);
		
		assertEquals(familiasAsJSON, responseBody);
	}
}
