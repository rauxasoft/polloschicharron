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
		<jsp:include page="nav.jsp"/>
		<h2>Listado Empleados</h2>
		<table class="table">
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