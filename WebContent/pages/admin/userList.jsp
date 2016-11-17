<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script type="text/javascript" src="javascript/lib/jquery/jquery.js"></script>
<title>Admin Home Page</title>
</head>
<body>
	<div class="container">
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Date Of Birth</th>
					<th>Email</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${students}" var="student">
					<tr>
						<td>${student.id}</td>
						<td>${student.username}</td>
						<td>${student.dob}</td>
						<td>${student.email}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>