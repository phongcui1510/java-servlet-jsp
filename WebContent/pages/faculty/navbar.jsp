<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">Feedback Management System</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="${context}/faculty/feedback/list">Feedback</a>
      </li>
      <li><a href="${context}/faculty/message/list">Message</a>
      </li>
    </ul>
    <ul class="nav navbar-nav" style="float: right">
    	<li ><a href="${context}/logout">Logout</a></li>
    </ul>
  </div>
</nav>