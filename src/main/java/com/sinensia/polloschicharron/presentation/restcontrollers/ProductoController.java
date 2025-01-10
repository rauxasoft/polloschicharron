package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.ProductoServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	private ProductoServices productoServices;
	
	public ProductoController(ProductoServices productosServices) {
		this.productoServices = productosServices;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProducto(@PathVariable Long id){
		
		try {
			productoServices.delete(id);
		} catch(IllegalStateException e) {
			
			HttpStatus httpStatus = null;
			String mensaje = null;
			
			if(id == null) {
				httpStatus = HttpStatus.BAD_REQUEST;
				mensaje = "La id es null";
			} else {
				httpStatus = HttpStatus.NOT_FOUND;
				mensaje = "No se encuentra el producto con id " + id;
			}
			
			HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado(mensaje);
			
			return new ResponseEntity<>(httpErrorCustomizado, httpStatus);

		}
		
		return ResponseEntity.noContent().build();
	}
	
	@GetMapping("/estadistica")
	public Map<Familia, Integer> getEstadistica(){
		return productoServices.getEstadisticaNumeroProductosPorFamilia();
	}
	
	// Operaciones CRUD 
	
	// "getAll"
	// "getByFamilia"

}
