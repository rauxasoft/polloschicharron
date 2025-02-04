package com.sinensia.polloschicharron.presentation.restcontrollers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MvcResult;

import com.sinensia.polloschicharron.business.model.Empleado;
import com.sinensia.polloschicharron.business.services.EmpleadoServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

@WebMvcTest(EmpleadoController.class)
@WithMockUser(username="u1", roles={"SUPER_ADMIN", "ADMIN", "USER"})
public class EmpleadoControllerTest extends AbstractControllerTest{

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
		
		List<Empleado> empleados = Arrays.asList(empleado1, empleado2);
		when(empleadoServices.getAll()).thenReturn(empleados);
		
		MvcResult mvcResult = mockMvc.perform(get("/rest/empleados").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
	
		testResponseBody(mvcResult, empleados);
			
	}
	
	@Test
	void pedimos_empleado_existente() throws Exception {
		
		when(empleadoServices.read(100L)).thenReturn(Optional.of(empleado1));

		MvcResult mvcResult = mockMvc.perform(get("/rest/empleados/100").contentType("application/json"))
								.andExpect(status().isOk())
								.andReturn();
	
		testResponseBody(mvcResult, empleado1);
		
	}
	
	@Test
	void pedimos_empleado_NO_existente() throws Exception {
		
		when(empleadoServices.read(100L)).thenReturn(Optional.empty());
		
		MvcResult mvcResult = mockMvc.perform(get("/rest/empleados/100").contentType("application/json"))
								.andExpect(status().isNotFound())
								.andReturn();
	
		testResponseBody(mvcResult, new HttpErrorCustomizado("No existe el empleado con ID 100"));
		
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
