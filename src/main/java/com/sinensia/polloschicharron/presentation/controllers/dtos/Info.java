package com.sinensia.polloschicharron.presentation.controllers.dtos;

import com.sinensia.polloschicharron.business.model.Familia;

public class Info {

	private Familia familia;
	private Integer cantidad;
	private Double precioMedio;
	
	public Info(Familia familia, Integer cantidad, Double precioMedio) {
		this.familia = familia;
		this.cantidad = cantidad;
		this.precioMedio = precioMedio;
	}
	
	public Familia getFamilia() {
		return familia;
	}
	
	public void setFamilia(Familia familia) {
		this.familia = familia;
	}
	
	public Integer getCantidad() {
		return cantidad;
	}

	public Double getPrecioMedio() {
		return precioMedio;
	}
}
