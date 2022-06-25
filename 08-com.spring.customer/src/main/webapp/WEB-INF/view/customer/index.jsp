<%@ include file="/WEB-INF/taglib/import.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer - Page</title>

<link rel="stylesheet" type="text/css" href="${contextPath}/resources/css/style.css" />

</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<form:form action="${contextPath}/customer/search" method="GET">
				Search Customer: <input type="text" name="param" value="${param.param}"/>
				<input type="submit" value="Search" class="add-button" />
			</form:form>

			<input type="button" value="Add Customer" class="add-button"
				onclick="window.location.href='${contextPath}/customer/add'; return false;" />

			<table>
				<tr>
					<c:url var="orderByFirstName" value="/customer/orderByFirstName" />
					<c:url var="orderByLastName" value="/customer/orderByLastName" />
					<c:url var="orderByEmail" value="/customer/orderByEmail" />
					<th><a href="${orderByFirstName}">First name</a></th>
					<th><a href="${orderByLastName}">Last name</a></th>
					<th><a href="${orderByEmail}">Email name</a></th>
					<th>Action</th>
				</tr>

				<c:forEach var="customer" items="${customers}">
					<!-- create updateLink with customer id-->
					<c:url var="updateLink" value="/customer/update">
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url>

					<!-- create deleteLink with customer id >> @RequestParam-->
					<c:url var="deleteLink" value="/customer/delete">
						<c:param name="id" value="${customer.id}"></c:param>
					</c:url>

					<tr>
						<td>${customer.firstName}</td>
						<td>${customer.lastName}</td>
						<td>${customer.email}</td>
						<td><a href="${updateLink}">Update</a> | <a
							href="${deleteLink}"
							onclick="if(!confirm('Are you sure you want to delete this customer ?')) return false">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>