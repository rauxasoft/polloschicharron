package com.sinensia.polloschicharron.integration.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="EMPLEADOS")
public class EmpleadoPL extends PersonaPL {
	
	private String licenciaManipuladorAlimentos;

	public EmpleadoPL() {
		
	}

	public String getLicenciaManipuladorAlimentos() {
		return licenciaManipuladorAlimentos;
	}

	public void setLicenciaManipuladorAlimentos(String licenciaManipuladorAlimentos) {
		this.licenciaManipuladorAlimentos = licenciaManipuladorAlimentos;
	}
	
	
}
