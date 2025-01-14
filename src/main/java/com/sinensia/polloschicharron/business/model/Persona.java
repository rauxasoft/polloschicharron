package com.sinensia.polloschicharron.business.model;

import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Table(name="PERSONAS")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Persona {

	@Id
	@Column(name="CODIGO")
	private Long id;
	
	private String DNI;
	private String nombre;
	private String apellido1;
	private String apellido2;
	
	@Embedded
	private Direccion direccion;
	
	@Embedded
	private DatosContacto datosContacto;
	
	public Persona() {
		
	}

	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getDNI() {
		return DNI;
	}

	public void setDNI(String dNI) {
		DNI = dNI;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
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
		return Objects.hash(DNI);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Persona other = (Persona) obj;
		return Objects.equals(DNI, other.DNI);
	}

	@Override
	public String toString() {
		return "Persona [DNI=" + DNI + ", nombre=" + nombre + ", apellido1=" + apellido1 + ", apellido2=" + apellido2
				+ ", direccion=" + direccion + ", datosContacto=" + datosContacto + "]";
	}

}
