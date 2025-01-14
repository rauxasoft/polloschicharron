package com.sinensia.polloschicharron.business.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class Empleado extends Persona {
	
	private String licenciaManipuladorAlimentos;

	public Empleado() {
		
	}

	public String getLicenciaManipuladorAlimentos() {
		return licenciaManipuladorAlimentos;
	}

	public void setLicenciaManipuladorAlimentos(String licenciaManipuladorAlimentos) {
		this.licenciaManipuladorAlimentos = licenciaManipuladorAlimentos;
	}
	
	
}
