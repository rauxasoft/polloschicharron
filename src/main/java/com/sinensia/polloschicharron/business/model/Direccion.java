package com.sinensia.polloschicharron.business.model;

import jakarta.persistence.Embeddable;

@Embeddable
public class Direccion {

	private String direccion;
	private String poblacion;
	private String codigoPostal;
	private String provincia;
	private String pais;
	
	public Direccion() {
		
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(String codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	@Override
	public String toString() {
		return "Direccion [direccion=" + direccion + ", poblacion=" + poblacion + ", codigoPostal=" + codigoPostal
				+ ", provincia=" + provincia + ", pais=" + pais + "]";
	}
	
}
