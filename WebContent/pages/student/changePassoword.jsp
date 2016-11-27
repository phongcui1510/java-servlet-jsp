<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css" />
<script type="text/javascript" src="javascript/lib/jquery/jquery.js"></script>
<title>Change Password</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Login</h3>
					</div>
					<div class="panel-body">
						<form action="login" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Old Password" name="oldPassword" type="password">
								</div>
								<div class="form-group">
									<input id="newPass" class="form-control" placeholder="New Password" name="newPassword" type="password">
								</div>
								<div class="form-group">
									<input id="confirmNewPass" class="form-control" placeholder="Confirm New Password" name="password" type="password">
								</div>
								<label id="error" style="color: red; display: none;"></label>
								<input id="submitBtn" type="submit" class="btn btn-success btn-block" value="Login">
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function(){
			$("#submitBtn").click(function(){
				var pass = $("#newPass").val();
				var confirmPass  = $("#confirmNewPass").val();
				if (pass !== confirmPass) {
					var error = $("#error").html("Confirm Password doesnot match");
					return false;
				}
			});
		});
	</script>
</body>
</html>