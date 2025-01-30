package com.sinensia.polloschicharron.business.model.dtos;

import java.util.Date;

public class PedidoDTO1 {
	
	private Long id;
	private Date fechaHora;
	private String establecimiento; // nombre en mayúsculas
	private String empleado;        // nombre completo en formato "GALVEZ RIDRUEJO, PEPÍN"
	private String estado;          // en forma de String

	public PedidoDTO1(Long id, Date fechaHora, String establecimiento, String empleado, String estadoPedido) {
		this.id = id;
		this.fechaHora = fechaHora;
		this.establecimiento = establecimiento;
		this.empleado = empleado;
		this.estado = estadoPedido;
	}

	public Long getId() {
		return id;
	}

	public Date getFechaHora() {
		return fechaHora;
	}

	public String getEstablecimiento() {
		return establecimiento;
	}

	public String getEmpleado() {
		return empleado;
	}

	public String getEstado() {
		return estado;
	}

}
