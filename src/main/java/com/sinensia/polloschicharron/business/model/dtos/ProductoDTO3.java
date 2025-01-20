package com.sinensia.polloschicharron.business.model.dtos;

public class ProductoDTO3 {
	
	private String nombre;
	private String familia;
	private double precio;
	private double precioDescuento;
	
	public ProductoDTO3() {
		
	}

	public ProductoDTO3(String nombre, String familia, double precio, double precioDescuento) {
		this.nombre = nombre;
		this.familia = familia;
		this.precio = precio;
		this.precioDescuento = precioDescuento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getFamilia() {
		return familia;
	}

	public void setFamilia(String familia) {
		this.familia = familia;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getPrecioDescuento() {
		return precioDescuento;
	}

	public void setPrecioDescuento(double precioDescuento) {
		this.precioDescuento = precioDescuento;
	}
	
	
	
	
	
	/*
	 *	// TODO
	 * 
	 * Opcional!
	 * 
	 * El DTO3 nos ofrece el atributo precioDescuento que es el precio aplicando un descuento que aportamos en la consulta.
	 * Ejemplo:
	 * 
	 * getDTO3(15.0); ----> Estamos pasando el parámetro 15 para realizar el descuento del 15%
	 * 
	 * 
	 */
	
}
