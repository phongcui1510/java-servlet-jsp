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
<title>Contact Us</title>
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
     <form class="form-horizontal" role="form" action="${context}/student/contact/create" method="post">
         <h2>Contact Us</h2>
         <div class="form-group">
             <label for="topic" class="col-sm-3 control-label">Name</label>
             <div class="col-sm-9">
                 <input type="text" id="name" placeholder="Name" class="form-control" autofocus name="name" required>
             </div>
         </div>
         <div class="form-group">
             <label for="topic" class="col-sm-3 control-label">Email</label>
             <div class="col-sm-9">
                 <input type="text" id="email" placeholder="Email" class="form-control" autofocus name="email" required>
             </div>
         </div>
         <div class="form-group">
             <label for="topic" class="col-sm-3 control-label">Subject</label>
             <div class="col-sm-9">
                 <input type="text" id="subject" placeholder="Subject" class="form-control" autofocus name="subject" required>
             </div>
         </div>
         <div class="form-group">
             <label for="topic" class="col-sm-3 control-label">Subject</label>
             <div class="col-sm-9">
                 <textarea style="resize: none; height: 200px" id="description" class="form-control" placeholder="Message" name="message" type="text"></textarea>
             </div>
         </div>
         <div class="form-group">
             <div class="col-sm-9 col-sm-offset-3">
                 <input type="submit" class="btn btn-success" value="Send" style="width: 120px">
             </div>
         </div>
         <c:if test="${not empty msg }">
	          <div class="form-group">
	             <div class="col-sm-9 col-sm-offset-3">
	                 <label style="color: green">${msg}</label>
	             </div>
	         </div>
         </c:if>
       </form>
	</div>
</body>
</html>