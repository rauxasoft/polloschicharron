package com.sinensia.polloschicharron.business.model.dtos;

public class EstablecimientoDTO1 {

	private String nombre;
	private String poblacion;
	private String telefono;
	
	public EstablecimientoDTO1(String nombre, String poblacion, String telefono) {
		this.nombre = nombre;
		this.poblacion = poblacion;
		this.telefono = telefono;
	}

	public String getNombre() {
		return nombre;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public String getTelefono() {
		return telefono;
	}
	
}
