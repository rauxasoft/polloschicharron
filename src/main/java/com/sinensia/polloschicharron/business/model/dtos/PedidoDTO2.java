package com.sinensia.polloschicharron.business.model.dtos;

import java.util.Date;

public class PedidoDTO2 {
	
	private Long id;
	private Date fechaHora;
	private String establecimiento; // nombre en mayúsculas
	private String NIF_cliente;     // si lo hubiera! Si no hay cliente es null
	private String empleado;        // nombre completo en formato "GALVEZ RIDRUEJO, PEPÍN"
	private String estado;          // en forma de String
	private int numeroLineas;		// número de lineas que tiene el pedido
	
	// TODO Crear PedidoDTO2
}
