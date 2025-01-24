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
		<div class="container-fluid">
			<jsp:include page="nav.jsp"/>
			<h3 style="margin-top: 15px;">Estadística de Productos</h3>
			<p>Número total de productos: ${numeroProductos}</p>
		<div>
			<table style="width: 70%;" class="table">
			<thead>
				<tr>
					<th>ID Familia</th>
					<th>Familia</th>
					<th style="text-align: right;">Número de productos</th>
					<th style="text-align: right;">Precio medio</th>
				</tr>
			</thead>
				<tbody>
					<c:forEach var="entry" items="${mapa1}" >
						<tr>
							<td>${entry.key.id}</td>
							<td>${entry.key.nombre}</td>
							<td style="text-align: right;">${entry.value}</td>
							
							<td style="text-align: right;">
								<c:if test="${not empty mapa2[entry.key]}">
								<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${mapa2[entry.key]}" /> €
								</c:if>
								<c:if test="${empty mapa2[entry.key]}">---</c:if>
							</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		</div>
	</body>
</html>