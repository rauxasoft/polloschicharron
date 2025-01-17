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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sinensia.polloschicharron.business.model.Familia;
import com.sinensia.polloschicharron.business.services.FamiliaServices;
import com.sinensia.polloschicharron.presentation.config.PresentationException;

@RestController
@RequestMapping("/familias")
public class FamiliaController {

	private FamiliaServices familiaServices;
	
	public FamiliaController(FamiliaServices familiaServices) {
		this.familiaServices = familiaServices;
	}
	
	@GetMapping
	public List<Familia> getFamilias(){
		return familiaServices.getAll();
	}
	
	@GetMapping("/{id}")
	public Familia getFamilia(@PathVariable Long id){
		
		Optional<Familia> optional = familiaServices.read(id);
		
		if(optional.isEmpty()) {
			throw new PresentationException("No existe la familia con id " + id, HttpStatus.NOT_FOUND);
		}
		
		return optional.get();
	}
	
	@PostMapping
	public ResponseEntity<?> createFamilia(@RequestBody Familia familia, UriComponentsBuilder ucb){
		
		Long id = null;
		
		try {
			id = familiaServices.create(familia);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		
		return ResponseEntity.created(ucb.path("/familias/{id}").build(id)).build();
	}
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void updateFamilia(@RequestBody Familia familia, @PathVariable Long id) {
		
		familia.setId(id);
		
		try {
			familiaServices.update(familia);
		} catch(IllegalStateException e) {
			throw new PresentationException(e.getMessage(), HttpStatus.BAD_REQUEST);
		}	
	}

}
