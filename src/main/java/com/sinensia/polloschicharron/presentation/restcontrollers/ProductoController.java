package com.sinensia.polloschicharron.presentation.restcontrollers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sinensia.polloschicharron.business.services.ProductoServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	private ProductoServices productosServices;
	
	public ProductoController(ProductoServices productosServices) {
		this.productosServices = productosServices;
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteProducto(@PathVariable Long id){
		
		try {
			productosServices.delete(id);
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
	
	// Operaciones CRUD 
	
	// "getAll"
	// "getByFamilia"

}
