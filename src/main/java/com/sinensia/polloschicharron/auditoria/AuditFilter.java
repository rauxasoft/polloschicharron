package com.sinensia.polloschicharron.auditoria;

import java.io.IOException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sinensia.polloschicharron.auditoria.integration.model.RequestLogPL;
import com.sinensia.polloschicharron.auditoria.integration.repositories.RequestLogPLRepository;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class AuditFilter implements Filter {

	@Autowired
	private RequestLogPLRepository requestLogPLRepository;
	
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		Long entrada = System.currentTimeMillis();
		
		chain.doFilter(request, response);
		
		Long elapsedTime = System.currentTimeMillis() - entrada;
		
		RequestLogPL requestLogPL = new RequestLogPL();
		requestLogPL.setTimeStamp(new Date(entrada));
		requestLogPL.setIp(request.getRemoteAddr());
		requestLogPL.setMethod(((HttpServletRequest) request).getMethod());
		requestLogPL.setPath(((HttpServletRequest) request).getRequestURI());
		HttpServletResponse res = (HttpServletResponse) response;
		requestLogPL.setStatusCode(res.getStatus());
		requestLogPL.setElapsedTime(elapsedTime);
		
		requestLogPLRepository.save(requestLogPL);
	
	}

}
