package com.sinensia.polloschicharron.business.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="ESTABLECIMIENTOS")
public class Establecimiento {
	
	@Id
	private String NIF; // business key
	
	@Column(name="NOMBRE_COMERCIAL")
	private String nombre;
	
	@Embedded
	private Direccion direccion;
	
	@Embedded
	private DatosContacto datosContacto;
	
	public Establecimiento() {
		
	}

	public String getNIF() {
		return NIF;
	}

	public void setNIF(String NIF) {
		this.NIF = NIF;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public DatosContacto getDatosContacto() {
		return datosContacto;
	}

	public void setDatosContacto(DatosContacto datosContacto) {
		this.datosContacto = datosContacto;
	}

	@Override
	public int hashCode() {
		return Objects.hash(NIF);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Establecimiento other = (Establecimiento) obj;
		return Objects.equals(NIF, other.NIF);
	}

	@Override
	public String toString() {
		return "Establecimiento [NIF=" + NIF + ", nombre=" + nombre + ", direccion=" + direccion + ", datosContacto="
				+ datosContacto + "]";
	}

}
