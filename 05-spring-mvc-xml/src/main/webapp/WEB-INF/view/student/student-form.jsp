<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/taglib/import.jsp" %>
<!-- Using for add, edit page 
	+ add: show empty form with input
	+ edit: show from with data of current student
-->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>STUDENT - ${title} PAGE</title>

</head>
<body>

	<h2>STUDENT ${title} PAGE</h2>

	<hr>
	
	<!-- path >> getter, setter attribute from model attribute -->
	<form:form action="${contextPath}/student/save" modelAttribute="student" method="POST">
	
		<form:input path="id" placeholder='Id' type="number"/> <br> <br>
		
		<form:input path="fullname" placeholder='FullName'/> 
		<form:errors path="fullname" cssStyle="color: red" />
		 
		<br> <br>
		
		<form:input path="yearOfBirth" placeholder='Year Of Birth'/>
		<form:errors path="yearOfBirth" cssStyle="color: red" />
		
		<br> <br>
		
		<form:select path="country">
			<c:forEach var="countryAsItem" items="${countries}">
				<form:option value="${countryAsItem}">${countryAsItem}</form:option>
			</c:forEach>
		</form:select> <br> <br>
		
		<c:forEach var="operatingSystemAsItem" items="${operatingSystems}">
			<form:checkbox path="operatingSystems" value="${operatingSystemAsItem}" label="${operatingSystemAsItem}"/>
		</c:forEach> <br> <br>
		
		<form:input path="course" placeholder='Course Name'/> 
		<form:errors path="course" cssStyle="color: red" />
		 
		<br> <br>
		
		<input type="submit" value="Save Student">
		
	</form:form>

</body>
</html>