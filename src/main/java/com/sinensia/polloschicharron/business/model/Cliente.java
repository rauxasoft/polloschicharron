package com.sinensia.polloschicharron.business.model;

public class Cliente extends Persona {

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
