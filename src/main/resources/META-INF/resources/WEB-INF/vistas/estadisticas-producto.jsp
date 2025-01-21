<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
				<li><a href="./lista-productos">Productos</a></li>
				<li><a href="./estadisticas-producto">Estadísticas Producto</a></li>
				<li><a href="">Pedidos</a></li>
			</ul>
		</nav>
		<hr>
		<h2>Estadística de Productos</h2>
		<p>Número total de productos: ${numeroProductos} </p>
	</body>
</html>