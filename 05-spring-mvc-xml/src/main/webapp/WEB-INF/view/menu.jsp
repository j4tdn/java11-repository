<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Spring MVC - HomePage</title>
</head>
<body>

	<h2>Welcome to Spring MVC - HomePage</h2>
	
	<hr>
	
	<h2> ALL THE BEST !!! </h2>
	
	<p>Click to switch to <a href="${pageContext.request.contextPath}/hello/show-form">Hello Form</a> </p>
	
	<p>Click to switch to <a href="${pageContext.request.contextPath}/student">Student</a> </p>

</body>
</html>