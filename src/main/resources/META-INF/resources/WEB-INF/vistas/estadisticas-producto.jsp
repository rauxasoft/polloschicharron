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
			<h2>Estadística de Productos</h2>
			<p>Número total de productos: ${numeroProductos}</p>
		
		<div>
			<table class="table">
				<thead>
					<tr>
						<th>ID Familia</th>
						<th>Familia</th>
						<th style="text-align: right;">Número de productos</th>
						<th style="text-align: right;">Precio medio</th>
					</tr>
				</thead>
				<tbody>
				<c:forEach var="fila" items="${listaResultados}">
					<tr>
						<td>${fila.familia.id}</td>
						<td>${fila.familia.nombre}</td>
						<td style="text-align: right;">${fila.cantidad}</td>
						<td style="text-align: right;">
							<c:if test="${not empty fila.precioMedio}">
								<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${fila.precioMedio}" /> €
							</c:if>
							<c:if test="${empty fila.precioMedio}">--</c:if>
						</td>
					</tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</body>
</html>