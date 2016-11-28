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
<style type="text/css">
	body {
    background-color: #eee;
}

*[role="form"] {
    max-width: 700px;
    padding: 15px;
    margin: 0 auto;
    background-color: #fff;
    border-radius: 0.3em;
}

*[role="form"] h2 {
    margin-left: 5em;
    margin-bottom: 1em;
}
	
</style>
<title>Message List</title>
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<table class="table table-condensed">
			<thead>
				<tr>
					<th>From</th>
					<th>Send Date</th>
					<th>Subject</th>
					<th>Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${messages}" var="message">
					<tr>
						<td>${message.sender}</td>
						<td>${message.date}</td>
						<td>${message.subject}</td>
						<td><a href="${context}/faculty/message/details?message=${message.id}">View</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>