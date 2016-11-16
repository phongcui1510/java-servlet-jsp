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
<title>User Creation</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Welcome to my site</h3>
					</div>
					<div class="panel-body">
						<form role="form" action="login" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Username" name="username" type="text" autofocus>
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Password" name="password" type="password">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Confirm Password" name="password" type="password">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Date Of Birth" name="dob" type="date">
								</div>
								<div class="form-group">
									<input class="form-control" placeholder="Email" name="email" type="text">
								</div>
								<!-- Change this to a button or input when using this as a form -->
								<input type="submit" class="btn btn-success btn-block">Login
								</button>
								<p>
									New Member? <a href="signUp.html" class="">Sign up</a>
								</p>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>