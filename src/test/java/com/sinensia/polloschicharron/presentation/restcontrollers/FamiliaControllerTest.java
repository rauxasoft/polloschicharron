package com.sinensia.polloschicharron.presentation.restcontrollers;

import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;
import java.util.List;

import com.sinensia.polloschicharron.auditoria.AuditFilter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MvcResult;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.FamiliaServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

@WebMvcTest(value=FamiliaController.class,
			excludeFilters = @ComponentScan.Filter(
								type = FilterType.ASSIGNABLE_TYPE,
								classes = AuditFilter.class))

@WithMockUser(username="u1", roles={"SUPER_ADMIN", "ADMIN", "USER"})

public class FamiliaControllerTest extends AbstractControllerTest{

	@MockitoBean
	private FamiliaServices familiaServices;
	
	private Familia familia1;
	private Familia familia2;
	
	@BeforeEach
	void init() {
		initObjects();
	}
	
	@Test
	void pedimos_todas_las_familias() throws Exception{
		
		List<Familia> familias = Arrays.asList(familia1, familia2);
		
		when(familiaServices.getAll()).thenReturn(familias);
		
		MvcResult mvcResult = mockMvc.perform(get("/rest/familias").contentType("application/json"))
									.andExpect(status().isOk())
									.andReturn();
		
		testResponseBody(mvcResult, familias);
		
	}
	
	@Test
	void creamos_familia_ok() throws Exception {
		
		Familia familia = new Familia();
		
		familia.setId(null);
		familia.setNombre("NUEVA_FAMILIA");
		
		String requestBody = mapper.writeValueAsString(familia);
		
		when(familiaServices.create(familia)).thenReturn(500L);
		
		mockMvc.perform(post("/rest/familias")
						.contentType("application/json")
						.content(requestBody)
						.with(csrf()))
			.andExpect(status().isCreated())
			.andExpect(header().string("Location", "http://localhost/rest/familias/500"));
		
	}
	
	@Test
	void creamos_familia_con_id_NOT_NULL() throws Exception {
		
		when(familiaServices.create(familia1)).thenThrow(new IllegalStateException("MENSAJE DE TURNO"));
		
		String requestBody = mapper.writeValueAsString(familia1);
		
		MvcResult mvcResult = mockMvc.perform(post("/rest/familias")
										.contentType("application/json")
										.content(requestBody)
										.with(csrf()))
								.andExpect(status().isBadRequest())
								.andReturn();

		testResponseBody(mvcResult, new HttpErrorCustomizado("MENSAJE DE TURNO"));
	}
	
	@Test
	void actualizamos_familia_ok() throws Exception {
		
		String requestBody = mapper.writeValueAsString(familia1);
		
		mockMvc.perform(put("/rest/familias/100")
							.contentType("application/json")
							.content(requestBody)
							.with(csrf()))
						.andExpect(status().isNoContent());
		
		verify(familiaServices, times(1)).update(familia1);
	}
	
	@Test
	void actualizamos_familia_NO_EXISTENTE() throws Exception {
		
		doThrow(new IllegalStateException("La familia 100 no existe")).when(familiaServices).update(familia1);

		String requestBody = mapper.writeValueAsString(familia1);
		
		MvcResult mvcResult = mockMvc.perform(put("/rest/familias/100")
												.contentType("application/json")
												.content(requestBody)
												.with(csrf()))
				 					.andExpect(status().isBadRequest())
				 					.andReturn();
				
		testResponseBody(mvcResult, new HttpErrorCustomizado("La familia 100 no existe"));
		
	}
	
	// ********************************************
	//
	// Private Methods
	//
	// ********************************************
	
	private void initObjects() {
		
		familia1 = new Familia();
		familia2 = new Familia();
		
		familia1.setId(100L);
		familia1.setNombre("TAPAS");
		
		familia2.setId(200L);
		familia2.setNombre("REFRESCOS");
		
	}
}
