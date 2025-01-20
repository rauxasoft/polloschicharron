package com.sinensia.polloschicharron.business.model.dtos;

public class EmpleadoDTO1 {

	private String nombre;
	private String apellidos;
	private String licencia;
	
	public EmpleadoDTO1(String nombre, String apellidos, String licencia) {
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.licencia = licencia;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public String getLicencia() {
		return licencia;
	}

}
