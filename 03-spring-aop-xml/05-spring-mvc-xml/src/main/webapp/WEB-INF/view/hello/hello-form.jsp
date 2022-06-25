<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Hello Form</title>
</head>
<body>
	<h2> Welcome to Hello Form </h2>
	
	<hr>
	
	<!-- METHOD: GET || POST  -->
	<form action="${pageContext.request.contextPath}/hello/submit-form" method="POST">
		<input type="text" name="name" placeholder="What's your name ?" /> <br> <br>
		<input type="number" name="age" placeholder="How old are you ?" /> <br> <br>
		
		<input type = "submit" value="Submit" />
	</form>
</body>
</html>