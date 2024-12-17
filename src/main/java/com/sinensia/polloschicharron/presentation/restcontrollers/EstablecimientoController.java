package com.sinensia.polloschicharron.presentation.restcontrollers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.polloschicharron.business.model.Establecimiento;
import com.sinensia.polloschicharron.business.services.EstablecimientoServices;
import com.sinensia.polloschicharron.presentation.config.HttpErrorCustomizado;

@RestController
@RequestMapping("/establecimientos")
public class EstablecimientoController {
	
	private EstablecimientoServices establecimientoServices;
	
	public EstablecimientoController(EstablecimientoServices establecimientoServices) {
		this.establecimientoServices = establecimientoServices;
	}
	
	@GetMapping
	public List<Establecimiento> getEstablecimientos(@RequestParam(required=false) String provincia){
	
		List<Establecimiento> establecimientos = null;
		
		if(provincia == null) {
			establecimientos = establecimientoServices.getAll();
		} else {
			establecimientos = establecimientoServices.getByProvincia(provincia);
		}
		
		return establecimientos;
	}
	
	@GetMapping("/{nif}")
	public ResponseEntity<?> getEstablecimiento(@PathVariable String nif){
		
		Optional<Establecimiento> optional = establecimientoServices.read(nif);
		
		if(optional.isEmpty()) {
			HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado("No existe el establecimiento con NIF " + nif);
			return new ResponseEntity<>(httpErrorCustomizado, HttpStatus.NOT_FOUND);
		}
		
		return ResponseEntity.of(optional);
	}
	
	@PostMapping
	public ResponseEntity<?> createEstablecimiento(@RequestBody Establecimiento establecimiento, UriComponentsBuilder ucb){
		
		try {
			establecimientoServices.create(establecimiento);
		} catch(IllegalStateException e) {
			HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado(e.getMessage());
			return new ResponseEntity<>(httpErrorCustomizado, HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.created(ucb.path("/establecimientos/{nif}").build(establecimiento.getNIF())).build();
	}
	
	@PutMapping
	public ResponseEntity<?> updateEstablecimiento(@RequestBody Establecimiento establecimiento) {
		
		try {
			establecimientoServices.update(establecimiento);
		} catch(IllegalStateException e) {
			HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado(e.getMessage());
			return new ResponseEntity<>(httpErrorCustomizado, HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.noContent().build();
		
	}
	
}
