<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width,initial-scale=1,maximum-scale=1">
<link rel="stylesheet" type="text/css"
	href="<c:url value="/css/bootstrap.css"/>" />
<script type="text/javascript"
	src="<c:url value="/javascript/lib/jquery/jquery.js"/>"></script>
<script type="text/javascript"
	src="<c:url value="/javascript/lib/bootstrap/bootstrap.js"/>"></script>
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
<title>Feed Details</title>
</head>
<body>
	<c:set var="context" value="${pageContext.request.contextPath}" />
	<jsp:include page="navbar.jsp"></jsp:include>
	<div class="container">
		<form class="form-horizontal" role="form">
			<h2>Feedback Details</h2>
			<div class="form-group">
				<label for="topic" class="col-sm-3 control-label">Topic Name: </label>
				<div class="col-sm-9">
					<label for="topic" style="padding-top: 7px; font-weight: 100">${feedback.topic}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="subjet" class="col-sm-3 control-label">Subject Name</label>
				<div class="col-sm-9">
					<label for="subject" style="padding-top: 7px; font-weight: 100">${feedback.subject}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="owner" class="col-sm-3 control-label">Sender Name</label>
				<div class="col-sm-9">
					<label for="owner" style="padding-top: 7px; font-weight: 100">${feedback.owner}</label>
				</div>
			</div>
			<div class="form-group">
				<label for="date" class="col-sm-3 control-label">Date of Visit</label>
				<div class="col-sm-9">
					<label for="date" style="padding-top: 7px; font-weight: 100">${feedback.date}</label>
				</div>
			</div>
			<hr/>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q1: How was the focus of the talk good?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100 ">Answer: ${feedback.a1}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q2: How far you found the lecture useful?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a2}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q3: How far did the lecturer meet your expectation?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a3}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q4: How far the lecturer managed to capture you attention?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a4}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q5: How did you find the lecturer vocabulary?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a5}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q6: How far audience participation & interaction encouraged?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a6}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q7: How far the lecturer appeared enthusiastic about the subject?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a7}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q8: Was the content interesting?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a8}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q9: Was the content understandable?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a9}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q10: Was the clarity in the content?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a10}</label>
			</div>
			<div class="form-group">
				<label for="email" style="padding-left: 50px">Q11: What suggestions do you have to improve the lectures approach?</label><br/>
				<label for="email" style="padding-left: 50px; font-weight: 100">Answer: ${feedback.a11}</label>
			</div>
		</form>
	</div>
</body>
</html>