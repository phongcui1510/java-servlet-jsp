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
<title>Feedback List</title>
</head>
<body>
<div class="container">
<c:set var="context" value="${pageContext.request.contextPath}" />
	<table class="table table-condensed">
		<thead>
			<tr>
				<th>Title</th>
				<th>Owner</th>
				<th>Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${feedbacks}" var="feedback">
				<tr>
					<td>${feedback.title}</td>
					<td>${feedback.owner}</td>
					<td>${feedback.date}</td>
					<td><a href="${context}/facult/feedback/view?feedback=${student.username}">View Details</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>