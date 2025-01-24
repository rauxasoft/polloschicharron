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
			<h2>Listado Pedidos</h2>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Fecha</th>
						<th>Hora</th>
						<th>Estado</th>
						<th>Establecimiento</th>
						<th>Empleado</th>
						
					</tr>
				</thead>
				<tbody>
					<c:forEach var="pedido" items="${pedidos}">
					<tr>
						<td><a href="./pedido?id=${pedido.id}">${pedido.id}</a></td>
						<td><fmt:formatDate pattern="dd/MM/yyyy" value="${pedido.fechaHora}" /></td>
						<td><fmt:formatDate pattern="HH:mm" value="${pedido.fechaHora}" /></td>
						<td>${pedido.estado}</td>
						<td>${pedido.establecimiento}</td>
						<td>${pedido.empleado}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>