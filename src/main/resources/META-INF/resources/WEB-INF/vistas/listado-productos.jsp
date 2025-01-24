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
			<h2>Listado Productos</h2>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Nombre</th>
						<th>Familia</th>
						<th style="text-align: right;">Precio</th>
						<th style="text-align: center;">Fecha de Alta</th>
						<th>Descatalogado</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="producto" items="${productos}">
					<tr>
						<td>${producto.id}</td>
						<td>${producto.nombre}</td>
						<td>${producto.familia.nombre}</td>
						<td style="text-align: right;">
							<fmt:formatNumber type="number" maxFractionDigits="2" minFractionDigits="2" value="${producto.precio}" /> €
						</td>
						<td style="text-align: center;">
							<fmt:formatDate pattern="dd/MM/yyyy" value="${producto.fechaAlta}" />
						</td>
						<td>
							<c:if test="${producto.descatalogado}"><span style="color: red;">DESCATALOGADO</span></c:if>
						</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>