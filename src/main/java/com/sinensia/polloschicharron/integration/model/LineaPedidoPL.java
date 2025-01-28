package com.sinensia.polloschicharron.integration.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class LineaPedidoPL {

	@ManyToOne
	@JoinColumn(name="CODIGO_PRODUCTO")
	private ProductoPL producto;
	
	private Double precio;
	private int cantidad;
	
	public LineaPedidoPL() {

	}

	public ProductoPL getProducto() {
		return producto;
	}

	public void setProducto(ProductoPL producto) {
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

