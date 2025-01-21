<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Pollos Chicharrón</title>
		<link rel="stylesheet" href="/css/estilos.css">
	</head>
	<body>
		<nav>
			<h1>Pollos Chicharrón</h1>
			<ul>
				<li><a href="./home">Home</a></li>
				<li><a href="./lista-empleados">Empleados</a></li>
				<li><a href="./estadisticas-producto">Estadísticas Producto</a></li>
				<li><a href="">Pedidos</a></li>
			</ul>
		</nav>
		<hr>
		<h2>Listado Empleados</h2>
		<table>
			<thead>
				<tr>
					<th>Nombre Completo</th>
					<th>Teléfono</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="empleado" items="${empleados}">
				<tr>
					<td>${empleado.nombreCompleto}</td>
					<td>${empleado.telefono}</td>
					<td>${empleado.email}</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>
</html>