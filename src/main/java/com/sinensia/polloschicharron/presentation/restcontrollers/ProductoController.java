package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.model.Producto;
import com.sinensia.polloschicharron.business.services.ProductoServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;
import com.sinensia.polloschicharron.presentation.config.PresentationException;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	
	private ProductoServices productoServices;
	
	public ProductoController(ProductoServices productosServices) {
		this.productoServices = productosServices;
	}
	
	@GetMapping
	public List<Producto> getAll(){
		return productoServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Producto getProducto(@PathVariable Long id) {
		
		Optional<Producto> optional = productoServices.read(id);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe el producto con id " + id, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
	}
	
	@PostMapping
	public ResponseEntity<?> createProducto(@RequestBody Producto producto, UriComponentsBuilder ucb){
		
		Long id = null;
		
		try {
			id = productoServices.create(producto);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.created(ucb.path("/productos/{id}").build(id)).build();
	}
	
	@PutMapping
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateProductoa(@RequestBody Producto producto) {
		
		try {
			productoServices.update(producto);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
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

}
