<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Pollos Chicharrón</title>
        <jsp:include page="common-in-head.jsp"/>
        <link href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ775/x71OD3yYlzCwpwwp8BWIueQLmrz4G" crossorigin="anonymous">
        <style>
            .logo {
                float: right;
                width: 200px;
            }
            .invoice {
                border: 1px solid #dee2e6;
                padding: 15px;
                border-radius: 5px;
            }
            .invoice-header {
                text-align: center;
                margin-bottom: 20px;
            }
            .invoice-details,
            .invoice-items {
                margin-bottom: 20px;
            }
            .invoice-item {
                display: flex;
                justify-content: space-between;
                border-bottom: 1px solid #dee2e6;
                padding: 10px 0;
            }
        </style>
    </head>
    <body>
        <jsp:include page="nav.jsp"/>
        <div class="container mt-4">
            <div class="invoice">
                <div class="d-flex justify-content-between align-items-center">
                    <h2 class="text-danger">Factura de Pedido</h2>
                    <img class="logo" src="/img/logo2.jpg" alt="Logotipo de la empresa"/>
                </div>
                <div class="invoice-header">
                    <h3>Pollos Chicharrón</h3>
                    <p>Calle Falsa 123, Ciudad Ficticia, País Imaginario</p>
                    <p><strong>Fecha: </strong><fmt:formatDate pattern="dd/MM/yyyy" value="${pedido.fechaHora}" /></p>
                    <p><strong>Hora: </strong><fmt:formatDate pattern="HH:mm" value="${pedido.fechaHora}" /></p>
                </div>
                <div class="invoice-details">
                    <p><strong>Empleado: </strong>${pedido.empleado.nombre}</p>
                    <p><strong>Establecimiento: </strong>${pedido.establecimiento.nombre}</p>
                    <p><strong>Cliente: </strong>${pedido.cliente.nombre}</p>
                    <p><strong>Estado: </strong>${pedido.estado}</p>
                    <p><strong>Observaciones: </strong>${pedido.observaciones}</p>
                </div>
                <div>
                    <h4 class="text-center">Lineas de Pedido</h4>
                 
        <table class="table table-striped">
            <thead class="thead-dark">
                <tr>
                    <th>Producto</th>
                    <th>Precio</th>
                    <th>Cantidad</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="linea" items="${pedido.lineas}">
                    <tr>
                        <td>${linea.producto.nombre}</td>
                        <td>${linea.precio}</td>
                        <td>${linea.cantidad}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>      

        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIyGoBWIeSHk/uP0I5oBm07Fq13ivI6tDkFsmk" crossorigin="anonymous"></script>
    </body>
</html>
