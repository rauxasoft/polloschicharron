<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		</div>
	</body>
</html>