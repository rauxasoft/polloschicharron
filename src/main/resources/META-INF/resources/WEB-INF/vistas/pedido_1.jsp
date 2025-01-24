<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Pollos Chicharrón</title>
		<jsp:include page="common-in-head.jsp"/>
	</head>
	<body>
		<div class="container">
			<jsp:include page="nav.jsp"/>
			<h2>Pedido</h2>
			<h4 style="margin-top: 15px;">Datos principales</h4>
			<div style="margin: 25px; padding:10px; background-color: beige;">
				<p><strong>Número de pedido</strong>: ${pedido.id}</p>
				<p><strong>Fecha:</strong>: <fmt:formatDate pattern="dd/MM/yyyy" value="${pedido.fechaHora}" /></p>
				<p><strong>Hora:</strong>: <fmt:formatDate pattern="HH:mm" value="${pedido.fechaHora}" /></p>
				<p><strong>Estado</strong>: ${pedido.estado}</p>
				<p><strong>Establecimiento</strong>: ${pedido.establecimiento.nombre}</p>
				<p><strong>Empleado</strong>: ${pedido.empleado.nombre} ${pedido.empleado.apellido1} ${pedido.empleado.apellido2}</p>
				<c:if test="${not empty pedido.cliente}">
					<p><strong>Cliente</strong>: ${pedido.cliente.nombre} ${pedido.cliente.apellido1} ${pedido.cliente.apellido2}</p>
				</c:if>
				<c:if test="${not empty pedido.observaciones}">
					<p><strong>Observaciones</strong>: ${pedido.observaciones}</p>
				</c:if>
			</div>
			<h4>Detalle</h4>
			<div style="margin: 25px;">
				<table class="table">
					<thead>
						<tr>
							<th>Producto</th>
							<th style="text-align: right;">Cantidad</th>
							<th style="text-align: right;">Precio</th>
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
		</div>
	</body>
</html>