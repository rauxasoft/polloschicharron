package com.sinensia.polloschicharron.business.model;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="FAMILIAS")
public class Familia {

	@Id
	private Long id;
	
	private String nombre;
	
	public Familia() {
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Familia other = (Familia) obj;
		return Objects.equals(id, other.id);
	}

	@Override
	public String toString() {
		return "Familia [id=" + id + ", nombre=" + nombre + "]";
	}
	
}
