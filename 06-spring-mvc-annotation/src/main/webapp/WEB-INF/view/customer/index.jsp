<%@ include file="/WEB-INF/taglib/import.jsp"%>

<!DOCTYPE html>
<html>

	<head>
<title>Customer Management Application</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css"
	rel="stylesheet">

</head>
<body>
<header>
	<nav class="navbar navbar-light bg-light">
		<div class="container-fluid">
		<a>Customer Management Application</a>
			
			<input name="text" class="form-control me-2" type="search" placeholder="Search"
						aria-label="Search">>
			<button class="btn btn-outline-success" type="submit">Search</button>			
	
		</div>	
	</nav>	
	
</header>	
	<main class = "container-fluid">
		<a href = "${contextPath}/customer/add"
			class="btn btn-primary btn-sm mt-3 mb-3"> <i
			class="far fa-address-book"></i> Add Customer>
		</a> 
	
		<table class = "table table-bordered table-sciped">
			<thead class = "table-dark">
				<tr>
					<th>First Name </th>
					<th>Last Name </th>
					<th>Email Name </th>
					<th>Action </th>
				</tr>
			</thead>
			
			<tbody>
			<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td> 
						<a href="${contextPath}/customer/update?id=${customer.id}" 
						class="btn btn-info btn-sm">Update</a>
						
						<a href="${contextPath}/customer/delete?id=${customer.id}"
						class="btn btn-info btn-sm" 
						onclick="if(!confirm('Are you sure yout want to delete this customer ?')) return false">
						Delete</a>
					 </td>
					
				</tr>
			</c:forEach>
			
			</tbody>
		
			
		
		</table>
	
	</main>


	
</body>
</html>