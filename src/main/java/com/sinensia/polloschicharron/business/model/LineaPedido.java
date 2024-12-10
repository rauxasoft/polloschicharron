package com.sinensia.polloschicharron.business.model;

public class LineaPedido {

	private Producto producto;
	private Double precio;
	private int cantidad;
	
	public LineaPedido() {

	}

	public Producto getProducto() {
		return producto;
	}

	public void setProducto(Producto producto) {
		this.producto = producto;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	@Override
	public String toString() {
		return "LineaPedido [producto=" + producto + ", precio=" + precio + ", cantidad=" + cantidad + "]";
	}

}

