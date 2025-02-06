<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
	<head>
		<title>Pollos Chicharrón</title>
	
	</head>
	<body>
		<div class="container-fluid">
		
			<h3 style="margin-top: 15px;">Request Logs</h3>
			<table class="table">
				<thead>
					<tr>
						<th>ID</th>
						<th>Request Date</th>
						<th>Request Time</th>
						<th>Path</th>
						<th>Method</th>
						<th>Remote IP</th>
						<th>Elapsed Time</th>
						<th>Status Code</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="log" items="${logs}">
					<tr>
						<td>${log.id}</td>
						<td>
							<fmt:formatDate pattern="dd/MM/yyyy" value="${log.timeStamp}" />
						</td>
						<td style="text-align: right;">
							<fmt:formatDate pattern="HH:mm:ss" value="${log.timeStamp}" />
						</td>
						<td>${log.path}</td>
						<td>${log.method}</td>
						<td>${log.ip}</td>
						<td>${log.elapsedTime}</td>	
						<td>${log.statusCode}</td>
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</body>
</html>