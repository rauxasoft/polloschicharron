package com.sinensia.polloschicharron.business.model.dtos;

public class ProductoDTO3 {
	
	private String nombre;
	private String familia;
	private double precio;
	private double precioDescuento;
	
	public ProductoDTO3(String nombre, String familia, double precio, double precioDescuento) {
		this.nombre = nombre;
		this.familia = familia;
		this.precio = precio;
		this.precioDescuento = precioDescuento;
	}

	public String getNombre() {
		return nombre;
	}

	public String getFamilia() {
		return familia;
	}

	public double getPrecio() {
		return precio;
	}

	public double getPrecioDescuento() {
		return precioDescuento;
	}

}
