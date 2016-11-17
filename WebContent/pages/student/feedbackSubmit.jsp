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
<script type="text/javascript" src="<c:url value="/javascript/lib/bootstrap/bootstrap.js"/>"></script>
<title>Submit Feedback</title>
</head>
<body>
<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Submit Feedback</h3>
					</div>
					<div class="panel-body">
						<form action="${action}" method="post">
							<fieldset>
								<div class="form-group">
									<input required id="username" class="form-control" placeholder="Title" name="title" type="text" autofocus>
								</div>
								<div class="form-group">
									<textarea required id="password" class="form-control" placeholder="Description" name="description" type="text"/>
								</div>
								<label id="errormsg" style="color: red; display: none;"></label>
								<c:if test="${not empty msg}">
									<label id="msg" style="color: green; display: none;">${msg }</label>
								</c:if>
								<input id="submitBtn" type="submit" class="btn btn-success btn-block" value="Register">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>