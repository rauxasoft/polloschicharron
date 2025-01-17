package com.sinensia.polloschicharron.business.model.dtos;

public class ProductoDTO2 {

	private String nombre;
	private int anyo;
	
	public ProductoDTO2(String nombre, int anyo) {
		this.nombre = nombre;
		this.anyo = anyo;
	}

	public String getNombre() {
		return nombre;
	}

	public int getAnyo() {
		return anyo;
	}

}
