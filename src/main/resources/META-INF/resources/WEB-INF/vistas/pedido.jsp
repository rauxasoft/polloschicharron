<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html lang="es">
<head>
    <title>Pedido</title>
   	<head>
		<title>Pollos Chicharrón</title>
		<jsp:include page="common-in-head.jsp"/>
	</head>
</head>
<body>
	<div class="container">
		<jsp:include page="nav.jsp"/>
		<h2 style="margin-bottom: 20px;">Pedido</h2>
		
		<section class="row mb-4">
			
			<div class="col-md-6">
	                <dl class="row" style="margin-left: 0;">
	                    <dt class="col-sm-4">Número</dt>
	                    <dd class="col-sm-8">${pedido.id}</dd>
	
	                    <dt class="col-sm-4">Fecha</dt>
	                    <dd class="col-sm-8"><fmt:formatDate pattern="dd/MM/yyyy" value="${pedido.fechaHora}" /></dd>
	
	                    <dt class="col-sm-4">Hora</dt>
	                    <dd class="col-sm-8"><fmt:formatDate pattern="HH:mm" value="${pedido.fechaHora}" /></dd>
	
	                    <dt class="col-sm-4">Estado</dt>
	                    <dd class="col-sm-8">${pedido.estado}</dd>
	
	                    <dt class="col-sm-4">Empleado</dt>
	                    <dd class="col-sm-8">${pedido.empleado.nombre} ${pedido.empleado.apellido1} ${pedido.empleado.apellido2}</dd>
	                
	                	<c:if test="${not empty pedido.cliente}">
						
						<dt class="col-sm-4">Cliente</dt> 
						<dd class="col-sm-8">${pedido.cliente.nombre} ${pedido.cliente.apellido1} ${pedido.cliente.apellido2}</dd>
					
						</c:if>
	                
	             		</dl>
	        	</div>
	    </section>
	
	    <section class="mb-4">
	            <h2 class="h5">Detalles del pedido</h2>
	            <div class="table-responsive">
	                <table class="table table-bordered">
	                    <thead class="table-dark">
	                        <tr>
	                            <th>Producto</th>
	                            <th>Cantidad</th>
	                            <th>Precio</th>
	                        </tr>
	                    </thead>
	                    <tbody>
	                    	
	                    <c:forEach var="linea" items="${pedido.lineas}">
						<tr>
							<td>${linea.producto.nombre}</td>
							<td style="text-align: right;">${linea.cantidad}</td>
							<td style="text-align: right;"><fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${linea.precio}" /> €</td>
						</tr>
						</c:forEach>
	                    </tbody>
	                </table>
	            </div>
	        </section>
	        
		<c:if test="${not empty pedido.observaciones}">
	    <section>
	       <h2 class="h5">Observaciones</h2>
	       <p>${pedido.observaciones}</p>
	    </section>
	    </c:if>
	    
	    <footer class="text-center py-4">
	        <p class="text-muted">&copy; 2024 Pollo Chicharrón</p>
	    </footer>
	</div>
</body>
</html>