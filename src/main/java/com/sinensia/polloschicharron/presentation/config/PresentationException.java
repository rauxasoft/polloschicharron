package com.sinensia.polloschicharron.presentation.config;

import org.springframework.http.HttpStatus;

public class PresentationException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	private HttpStatus httpStatus;
	
	public PresentationException(String mensaje, HttpStatus httpStatus) {
		super(mensaje);
		this.httpStatus = httpStatus;
	}
	
	public PresentationException(String mensaje, int httpStatusCode) {
		super(mensaje);
		this.httpStatus = HttpStatus.valueOf(httpStatusCode);
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}
}
