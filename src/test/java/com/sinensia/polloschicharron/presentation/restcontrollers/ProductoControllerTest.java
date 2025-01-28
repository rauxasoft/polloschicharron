package com.sinensia.polloschicharron.presentation.restcontrollers;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;

import com.sinensia.polloschicharron.business.services.ProductoServices;

@WebMvcTest(ProductoController.class)
public class ProductoControllerTest extends AbstractControllerTest{

	@MockitoBean
	private ProductoServices productoServices;
	
	@Test
	void eliminamos_producto_ok() throws Exception {
		
		mockMvc.perform(delete("/rest/productos/50"))
				.andExpect(status().isNoContent());
		
		verify(productoServices, times(1)).delete(50L);
		
	}
}
