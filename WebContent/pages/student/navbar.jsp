<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Feedback Management System</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${context}/student/feedback/create">Feedback</a>
      </li>
      <li><a href="${context}/student/message/create">Message</a>
      </li>
      <li><a href="${context}/student/contact/create">Contact Us</a></li>
      <li><a href="${context}/student/changePassword">Change Password</a></li>
    </ul>
    <ul class="nav navbar-nav" style="float: right">
    	<li ><a href="${context}/logout">Logout</a></li>
    </ul>
    <!--  <p style="float: right; color: #9d9d9d; padding: 10px 15px 10px 15px">Login as ${currentUser.firstName} ${currentUser.lastName}</p>-->
  </div>
</nav>