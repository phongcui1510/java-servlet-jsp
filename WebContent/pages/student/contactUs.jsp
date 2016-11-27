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
<title>Contact Us</title>
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Contact Us</h3>
					</div>
					<div class="panel-body">
						<form action="${contect}/student/contactUs" method="post">
							<fieldset>
								<div class="form-group">
									<input required class="form-control" placeholder="Name" name="name" type="text" autofocus>
								</div>
								<div class="form-group">
									<input required class="form-control" placeholder="Email" name="email" type="text" autofocus>
								</div>
								<div class="form-group">
									<input required id="title" class="form-control" placeholder="Subject" name="subject" type="text" autofocus>
								</div>
								<div class="form-group">
									<textarea style="resize: vertical;" required id="description" class="form-control" placeholder="Message" name="message" type="text"></textarea>
								</div>
								<input id="submitBtn" type="submit" class="btn btn-success btn-block" value="Submit">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>