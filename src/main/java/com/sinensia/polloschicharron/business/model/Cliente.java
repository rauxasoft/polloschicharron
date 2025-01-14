package com.sinensia.polloschicharron.business.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="CLIENTES")
public class Cliente extends Persona {

	@Column(name="GOLD")
	private boolean clienteGold;
	
	public Cliente() {
		
	}

	public boolean isClienteGold() {
		return clienteGold;
	}

	public void setClienteGold(boolean clienteGold) {
		this.clienteGold = clienteGold;
	}

	@Override
	public String toString() {
		return "Cliente [clienteGold=" + clienteGold + ", toString()=" + super.toString() + "]";
	}
	
}
