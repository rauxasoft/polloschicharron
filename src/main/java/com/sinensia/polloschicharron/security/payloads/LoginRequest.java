package com.sinensia.polloschicharron.security.payloads;

import java.io.Serializable;

public class LoginRequest implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String password;
	
	public LoginRequest() {
		
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}
	
}
