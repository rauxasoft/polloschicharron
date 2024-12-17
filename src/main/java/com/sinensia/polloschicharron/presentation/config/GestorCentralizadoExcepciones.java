package com.sinensia.polloschicharron.presentation.config;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GestorCentralizadoExcepciones extends ResponseEntityExceptionHandler{

	// **********************************************************************************

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
		HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado("No se puede parsear el objeto JSON");
		return ResponseEntity.badRequest().body(httpErrorCustomizado);
	}
	
	// **********************************************************************************
	
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex){
	
		String tipoRequerido = ex.getRequiredType().getSimpleName();
		String tipoEntrante = ex.getValue().getClass().getSimpleName();
		
		HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado("El valor [" + ex.getValue() + "] es de tipo [" + tipoEntrante+ "]. Se requiere un tipo [" + tipoRequerido + "]");
		
		return ResponseEntity.badRequest().body(httpErrorCustomizado);
	}
	
	// **********************************************************************************
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Object> handleException(Exception ex){
	
		HttpErrorCustomizado httpErrorCustomizado = new HttpErrorCustomizado("Se ha producido un error en el servidor.");
		
		return ResponseEntity.internalServerError().body(httpErrorCustomizado);
	}
	
	

}