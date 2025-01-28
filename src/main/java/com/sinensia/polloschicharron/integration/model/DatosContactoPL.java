package com.sinensia.polloschicharron.integration.model;

import java.util.Objects;

import jakarta.persistence.Embeddable;

@Embeddable
public class DatosContactoPL {

	private String telefono;
	private String movil;
	private String email;
	
	public DatosContactoPL() {
		
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getMovil() {
		return movil;
	}

	public void setMovil(String movil) {
		this.movil = movil;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		return Objects.hash(email, movil, telefono);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DatosContactoPL other = (DatosContactoPL) obj;
		return Objects.equals(email, other.email) && Objects.equals(movil, other.movil)
				&& Objects.equals(telefono, other.telefono);
	}
	
}
