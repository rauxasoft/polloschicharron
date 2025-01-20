package com.sinensia.polloschicharron.business.model.dtos;

public class EmpleadoDTO2 {

	private String nombreCompleto;
	private String telefono;
	private String email;
	
	public EmpleadoDTO2(String nombreCompleto, String telefono, String email) {
		this.nombreCompleto = nombreCompleto;
		this.telefono = telefono;
		this.email = email;
	}

	public String getNombreCompleto() {
		return nombreCompleto;
	}

	public String getTelefono() {
		return telefono;
	}

	public String getEmail() {
		return email;
	}
	
}
