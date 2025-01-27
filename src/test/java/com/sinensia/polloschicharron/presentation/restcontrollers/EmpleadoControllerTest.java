package com.sinensia.polloschicharron.presentation.restcontrollers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.nio.charset.StandardCharsets;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

@WebMvcTest(EmpleadoController.class)
public class EmpleadoControllerTest {

	@Autowired
	private MockMvc miniPostman;
	
	@Autowired
	private ObjectMapper mapper; // Para convertir de JSON a Java y de Java a JSON (El JSON es un String)
	
	@MockitoBean
	private EmpleadoServices empleadoServices;
	
	private Empleado empleado1;
	private Empleado empleado2;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	@Test
	void pedimos_todos_los_establecimientos() throws Exception{
		
		// Arrange
		
		List<Empleado> empleados = Arrays.asList(empleado1, empleado2);
		
		when(empleadoServices.getAll()).thenReturn(empleados);
		
		// Act
		
		MvcResult respuesta = miniPostman.perform(get("/rest/empleados").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		// Assert
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String empleadosAsJSON = mapper.writeValueAsString(empleados);
		
		assertEquals(empleadosAsJSON, responseBody);
			
	}
	
	@Test
	void pedimos_empleado_existente() throws Exception {
		
		// Arrange
		
		when(empleadoServices.read(100L)).thenReturn(Optional.of(empleado1));
		
		// Act
		
		MvcResult respuesta = miniPostman.perform(get("/rest/empleados/100").contentType("application/json"))
								.andExpect(status().isOk())
								.andReturn();
		
		// Assert
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String empleadoAsJSON = mapper.writeValueAsString(empleado1);
		
		assertEquals(empleadoAsJSON, responseBody);
		
	}
	
	@Test
	void pedimos_empleado_NO_existente() throws Exception {
		
		when(empleadoServices.read(100L)).thenReturn(Optional.empty());
		
		MvcResult respuesta = miniPostman.perform(get("/rest/empleados/100").contentType("application/json"))
								.andExpect(status().isNotFound())
								.andReturn();
		
		String responseBody = respuesta.getResponse().getContentAsString(StandardCharsets.UTF_8);
		String errorJSON = mapper.writeValueAsString(new HttpErrorCustomizado("No existe el empleado con ID 100"));
		
		assertEquals(errorJSON, responseBody);
		
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************
	
	private void initObjects() {
		
		empleado1 = new Empleado();
		empleado2 = new Empleado();
		
		empleado1.setId(100L);
		empleado2.setId(200L);
		
		empleado1.setDNI("11111111L");
		empleado2.setDNI("22222222R");
	}
	
}
