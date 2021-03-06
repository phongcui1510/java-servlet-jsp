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
</head>
<body>
<c:set var="context" value="${pageContext.request.contextPath}" />
<jsp:include page="navbar.jsp"></jsp:include>
<div class="container">
            <form class="form-horizontal" role="form" action="${context}/student/feedback/create" method="post">
                <h2>Feedback Form</h2>
                <div class="form-group">
                    <label for="topic" class="col-sm-3 control-label">Topic Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="topic" placeholder="Topic" class="form-control" autofocus name="topic" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="subject" class="col-sm-3 control-label">Subject Name</label>
                    <div class="col-sm-9">
                        <input type="text" id="subject" placeholder="Subject Name" class="form-control" autofocus name="subject" required>
                    </div>
                </div>
                <div class="form-group">
                    <label for="dov" class="col-sm-3 control-label" >Date of Visit</label>
                    <div class="col-sm-9">
                        <input type="date" id="date" class="form-control" name="date" required>
                    </div>
                </div>
                <hr>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q1: How was the focus of the talk good?</label><br/>
                    <div style="margin-left: 100px">
                    	<div style="width: 100px; float: left"><input type="radio" value="Excellent" name="a1" required><label style="font-weight: 100">Excellent</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Very Good" name="a1" required><label style="font-weight: 100">Very Good</label></div>
                    	<div style="width: 80px; float: left"><input type="radio" value="Good" name="a1" required><label style="font-weight: 100">Good</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Average" name="a1" required><label style="font-weight: 100">Average</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Poor" name="a1" required><label style="font-weight: 100">Poor</label></div>
                      </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q2: How far you found the lecture useful?</label><br/>
                    <div style="margin-left: 100px">
                    	<div style="width: 100px; float: left"><input type="radio" value="Excellent" name="a2" required><label style="font-weight: 100">Excellent</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Very Good" name="a2" required><label style="font-weight: 100">Very Good</label></div>
                    	<div style="width: 80px; float: left"><input type="radio" value="Good" name="a2" required><label style="font-weight: 100">Good</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Average" name="a2" required><label style="font-weight: 100">Average</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Poor" name="a2" required><label style="font-weight: 100">Poor</label></div>
                      </div>
                </div>
                <div class="form-group">
                   <label for="email" style="padding-left: 50px">Q3: How far did the lecturer meet your expectation?</label><br/>
                    <div style="margin-left: 100px">
                    	<div style="width: 100px; float: left"><input type="radio" value="Excellent" name="a3" required><label style="font-weight: 100">Excellent</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Very Good" name="a3"><label style="font-weight: 100">Very Good</label></div>
                    	<div style="width: 80px; float: left"><input type="radio" value="Good" name="a3"><label style="font-weight: 100">Good</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Average" name="a3"><label style="font-weight: 100">Average</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Poor" name="a3"><label style="font-weight: 100">Poor</label></div>
                      </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q4: How far the lecturer managed to capture you attention?</label><br/>
                    <div style="margin-left: 100px">
                    	<div style="width: 100px; float: left"><input type="radio" value="Excellent" name="a4" required><label style="font-weight: 100">Excellent</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Very Good" name="a4"><label style="font-weight: 100">Very Good</label></div>
                    	<div style="width: 80px; float: left"><input type="radio" value="Good" name="a4"><label style="font-weight: 100">Good</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Average" name="a4"><label style="font-weight: 100">Average</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Poor" name="a4"><label style="font-weight: 100">Poor</label></div>
                      </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q5: How did you find the lecturer vocabulary?</label><br/>
                    <div style="margin-left: 100px">
                    	<div style="width: 100px; float: left"><input type="radio" value="Excellent" name="a5" required><label style="font-weight: 100">Excellent</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Very Good" name="a5"><label style="font-weight: 100">Very Good</label></div>
                    	<div style="width: 80px; float: left"><input type="radio" value="Good" name="a5"><label style="font-weight: 100">Good</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Average" name="a5"><label style="font-weight: 100">Average</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Poor" name="a5"><label style="font-weight: 100">Poor</label></div>
                      </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q6: How far audience participation & interaction encouraged?</label><br/>
                    <div style="margin-left: 100px">
                    	<div style="width: 100px; float: left"><input type="radio" value="Excellent" name="a6" required><label style="font-weight: 100">Excellent</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Very Good" name="a6"><label style="font-weight: 100">Very Good</label></div>
                    	<div style="width: 80px; float: left"><input type="radio" value="Good" name="a6"><label style="font-weight: 100">Good</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Average" name="a6"><label style="font-weight: 100">Average</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Poor" name="a6"><label style="font-weight: 100">Poor</label></div>
                      </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q7: How far the lecturer appeared enthusiastic about the subject?</label><br/>
                    <div style="margin-left: 100px">
                    	<div style="width: 100px; float: left"><input type="radio" value="Excellent" name="a7" required><label style="font-weight: 100">Excellent</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Very Good" name="a7"><label style="font-weight: 100">Very Good</label></div>
                    	<div style="width: 80px; float: left"><input type="radio" value="Good" name="a7"><label style="font-weight: 100">Good</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Average" name="a7"><label style="font-weight: 100">Average</label></div>
                    	<div style="width: 100px; float: left"><input type="radio" value="Poor" name="a7"><label style="font-weight: 100">Poor</label></div>
                      </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q8: Was the content interesting?</label><br/>
                    <div style="margin-left: 100px">
	                   	<div style="width: 100px; float: left"><input type="radio" value="Yes" name="a8" required><label style="font-weight: 100">Yes</label></div>
	                   	<div style="width: 100px; float: left"><input type="radio" value="No" name="a8"><label style="font-weight: 100">No</label></div>
                     </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q9: Was the content understandable?</label><br/>
                    <div style="margin-left: 100px">
	                   	<div style="width: 100px; float: left"><input type="radio" value="Yes" name="a9" required><label style="font-weight: 100">Yes</label></div>
	                   	<div style="width: 100px; float: left"><input type="radio" value="No" name="a9"><label style="font-weight: 100">No</label></div>
                     </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q10: Was the clarity in the content?</label><br/>
                    <div style="margin-left: 100px">
	                   	<div style="width: 100px; float: left"><input type="radio" value="Yes" name="a10" required><label style="font-weight: 100">Yes</label></div>
	                   	<div style="width: 100px; float: left"><input type="radio" value="No" name="a10"><label style="font-weight: 100">No</label></div>
                     </div>
                </div>
                <div class="form-group">
                    <label for="email" style="padding-left: 50px">Q11: What suggestions do you have to improve the lectures approach?</label><br/>
                    <div style="margin-left: 100px">
	                   	<textarea name="a11" style="resize: none;height: 200px; width: 420px"></textarea>
                     </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-9 col-sm-offset-3">
                        <input type="submit" class="btn btn-success" value="Submit" style="width: 120px">
                    </div>
                </div>
                <c:if test="${not empty msg }">
                	<div class="form-group">
	                    <div style="margin-left: 100px">
		                   	<label style="color: green">${msg}</label>
	                     </div>
	                </div>
				</c:if>
            </form> <!-- /form -->
        </div> <!-- ./container -->
</body>
</html>