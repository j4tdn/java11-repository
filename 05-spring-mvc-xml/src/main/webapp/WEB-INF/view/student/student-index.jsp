<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STUDENT - INDEX PAGE</title>
<link href="${contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />

</head>
<body>
	<h2 class="header">STUDENT INDEX PAGE</h2>
	
	<hr>
	
	<a  href="${contextPath}/student/add" class="btn-add" >+</a>
	
	<hr>
	
	<table border="1">
		<thead>
			<tr>
				<th>ID</th>
				<th>FULLNAME</th>
				<th>AGE</th>
				<th>COUNTRY</th>
				<th>OPERATING SYSTEMS</th>
				<th>COURSE NAME</th>
				<th>----</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="student" items="${students}">
			<tr>
				<td>${student.id}</td>				
				<td>${student.fullname}</td>				
				<td>${student.age}</td>	
				<td>${student.country}</td>	
				<td>${student.osAsString}</td>
				<td>${student.course}</td>
				<td><a href="${contextPath}/student/edit?id=${student.id}">Edit</a></td>	
			</tr>
			</c:forEach>
		</tbody>
		
	</table>
</body>
</html>