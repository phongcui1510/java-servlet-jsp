<%@ page language="java" contentType="text/html; charset=utf-8"
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
<title>Change Password</title>
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class="panel-heading">
						<h3 class="panel-title">Change Password</h3>
					</div>
					<div class="panel-body">
						<form action="${context}/student/changePassword" method="post">
							<fieldset>
								<div class="form-group">
									<input class="form-control" placeholder="Old Password" type="password" name="oldPass">
								</div>
								<div class="form-group">
									<input id="newPass" class="form-control" placeholder="New Password" type="password" name="newPass">
								</div>
								<div class="form-group">
									<input id="confirmNewPass" class="form-control" placeholder="Confirm New Password" name="confirmNewPass" type="password">
								</div>
								<label id="error" style="color: red;">${error}</label>
<%-- 								<c:if test="${not empty msg}"> --%>
									<label style="color: green;">${msg}</label>
<%-- 								</c:if> --%>
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
					var error = $("#error").html("Confirm Password does not match");
					return false;
				}
			});
		});
	</script>
</body>
</html>