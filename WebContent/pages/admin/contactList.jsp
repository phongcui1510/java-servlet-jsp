<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>" />
<script type="text/javascript" src="<c:url value="/javascript/lib/jquery/jquery.js"/>"></script>
<script type="text/javascript" src="<c:url value="/javascript/lib/bootstrap/bootstrap.js"/>"></script>
<title>Contact List</title>
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Subject</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${contacts}" var="contact">
					<tr>
						<td>${contact.name}</td>
						<td>${contact.email}</td>
						<td>${contact.subject}</td>
						<td><a href="${context}/admin/contact/details?contact=${contact.id}">View</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>