<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1">
<link rel="stylesheet" type="text/css" href="<c:url value="/css/bootstrap.css"/>" />
<script type="text/javascript" src="<c:url value="/javascript/lib/jquery/jquery.js"/>"></script>
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
<title>Student Details</title>
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath}" />
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<form class="form-horizontal" role="form" action="${context}/admin/student/edit" method="get">
			<h2>Student Details</h2>
			<div class="form-group">
				<label for="from" class="col-sm-3 control-label">ID: </label>
				<div class="col-sm-9">
					<label for="from" style="padding-top: 7px; font-weight: 100">${student.id}</label>
					<input type="hidden" value="${student.id}" name="id">
				</div>
			</div>
			<div class="form-group">
				<label for="from" class="col-sm-3 control-label">User Name: </label>
				<div class="col-sm-9">
					<label for="from" style="padding-top: 7px; font-weight: 100">${student.username}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="from" class="col-sm-3 control-label">First Name: </label>
				<div class="col-sm-9">
					<label for="from" style="padding-top: 7px; font-weight: 100">${student.firstName}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="subject" class="col-sm-3 control-label">Last Name: </label>
				<div class="col-sm-9">
					<label for="subject" style="padding-top: 7px; font-weight: 100">${student.lastName}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="message" class="col-sm-3 control-label">Date of Birth: </label>
				<div class="col-sm-9">
					<label for="message" style="padding-top: 7px; font-weight: 100">${student.dob}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="message" class="col-sm-3 control-label">Email: </label>
				<div class="col-sm-9">
					<label for="message" style="padding-top: 7px; font-weight: 100">${student.email}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="message" class="col-sm-3 control-label">Address: </label>
				<div class="col-sm-9">
					<label for="message" style="padding-top: 7px; font-weight: 100">${student.address}</label>
				</div>
			</div>
			<div class="form-group">
                  <div class="col-sm-9 col-sm-offset-3">
                      <input type="submit" class="btn btn-success" value="Edit" style="width: 120px">
                  </div>
              </div>
		</form>
	</div>
</body>
</html>