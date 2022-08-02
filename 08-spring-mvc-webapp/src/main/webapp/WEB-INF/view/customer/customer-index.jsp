<%@ include file="/WEB-INF/taglib/import.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="${contextPath}/resources/css/style.css">

</head>
<body>
	<header>
		<nav class="navbar navbar-light bg-light navbar-expand-lg">
			<div class="container-fluid">
				<button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerId" aria-controls="#navbarTogglerId" aria-expanded="false" aria-label="Toggle navigation">
			      <span class="navbar-toggler-icon"></span>
			    </button>
				<a class="navbar-brand" href="${contextPath}">
					<svg xmlns="http://www.w3.org/2000/svg" width="42" height="32" fill="currentColor" class="bi bi-person-badge" viewBox="0 0 16 16">
					  <path d="M6.5 2a.5.5 0 0 0 0 1h3a.5.5 0 0 0 0-1h-3zM11 8a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
					  <path d="M4.5 0A2.5 2.5 0 0 0 2 2.5V14a2 2 0 0 0 2 2h8a2 2 0 0 0 2-2V2.5A2.5 2.5 0 0 0 11.5 0h-7zM3 2.5A1.5 1.5 0 0 1 4.5 1h7A1.5 1.5 0 0 1 13 2.5v10.795a4.2 4.2 0 0 0-.776-.492C11.392 12.387 10.063 12 8 12s-3.392.387-4.224.803a4.2 4.2 0 0 0-.776.492V2.5z"/>
					</svg>	
				</a>
				<div class="collapse navbar-collapse" id="#navbarTogglerId">

					<ul class="navbar-nav me-auto mb-2 mb-lg-0">
						<li class="nav-item">
							<a class="nav-link customer-nav" aria-current="page" href="${contextPath}/customer">Customer</a>
						</li>
						<li class="nav-item">
							<a class="nav-link stuff-nav" href="${contextPath}/stuff">Stuff</a>
						</li>
						<li class="nav-item">
							<a class="nav-link admin-nav" href="#" tabindex="-1" aria-disabled="true">Admin</a>
						</li>
					</ul>

					<form:form action="" method="GET" class="d-flex">
						<input name="text" value=""
							class="form-control me-2" type="search" placeholder="Search"
							aria-label="Search">
						<button class="btn btn-outline-success" type="submit">Search</button>
					</form:form>
				</div>
			</div>
		</nav>
	</header>


	<main class="container-fluid">
		<div class="toolbar">
			<a href="${contextPath}/customer/add" class="btn btn-primary btn-sm mt-3 mb-3"> 
				<i class="far fa-address-book"></i> Add Customer
			</a>
			
			<p class="info-message text-success">${param.message}</p>
		</div>
		
		<table class="table table-bordered table-striped">
			<thead class="table-dark">
				<tr>
					<th>
						<!-- Nếu hiện tại đang sắp xếp theo id thì reverseOrder, ngược lại sắp xếp theo id bằng sortDir hiện tại  -->
						<a href="${contextPath}/customer/page/${currentPage}?sortField=id&sortDir=${sortField == 'id' ? reversedOrder : 'asc'}" class="text-white">Id</a>
						<c:if test="${sortField == 'id'}">
							<span class="${sortDir == 'asc' ? 'fas fa-sort-up' : 'fas fa-sort-down'}"></span>
						</c:if>
					</th>
					<th>
						<a href="${contextPath}/customer/page/${currentPage}?sortField=firstName&sortDir=${sortField == 'firstName' ? reversedOrder : 'asc'}" class="text-white">First name</a>
						<c:if test="${sortField == 'firstName'}">
							<span class="${sortDir == 'asc' ? 'fas fa-sort-up' : 'fas fa-sort-down'}"></span>
						</c:if>
					</th>
					<th>
						<a href="${contextPath}/customer/page/${currentPage}?sortField=lastName&sortDir=${sortField == 'lastName' ? reversedOrder : 'asc'}" class="text-white">Last name</a>
						<c:if test="${sortField == 'lastName'}">
							<span class="${sortDir == 'asc' ? 'fas fa-sort-up' : 'fas fa-sort-down'}"></span>
						</c:if>
					</th>
					<th>
						<a href="${contextPath}/customer/page/${currentPage}?sortField=email&sortDir=${sortField == 'email' ? reversedOrder : 'asc'}" class="text-white">Email</a>
						<c:if test="${sortField == 'email'}">
							<span class="${sortDir == 'asc' ? 'fas fa-sort-up' : 'fas fa-sort-down'}"></span>
						</c:if>
					</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach var="customer" items="${customers}">
				<tr>
					<td>${customer.id}</td>
					<td>${customer.firstName}</td>
					<td>${customer.lastName}</td>
					<td>${customer.email}</td>
					<td>
						<a href="${contextPath}/customer/update?id=${customer.id}" class="btn btn-info btn-sm">Update</a> 
						<a  onclick="if(!confirm('Do you really want to delete customer ${customer.id} ?'))  return false;"
							href="${contextPath}/customer/delete?id=${customer.id}" class="btn btn-danger btn-sm">Delete</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>

		<nav class="float-end">
			<ul class="pagination">
				<li class="page-item ${currentPage <= 1 ? 'disabled' : ''}">
			      <a class="page-link" href="${contextPath}/customer/page/1?sortField=${sortField}&sortDir=${sortDir}">First</a>
			    </li>
				<li class="page-item ${currentPage <= 1 ? 'disabled' : ''}">
			      <a class="page-link" href="${contextPath}/customer/page/${currentPage-1}?sortField=${sortField}&sortDir=${sortDir}">Previous</a>
			    </li>
				
				<c:forEach var="i" begin="1" end="${totalPages}">
			    <li class="page-item ${i == currentPage ? 'active' : ''}">
			    	<a class="page-link" href="${contextPath}/customer/page/${i}?sortField=${sortField}&sortDir=${sortDir}">${i}</a>
			    </li>
			    </c:forEach>
			    
			    <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
			      <a class="page-link" href="${contextPath}/customer/page/${currentPage+1}?sortField=${sortField}&sortDir=${sortDir}">Next</a>
			    </li>
			    <li class="page-item ${currentPage == totalPages ? 'disabled' : ''}">
			      <a class="page-link" href="${contextPath}/customer/page/${totalPages}?sortField=${sortField}&sortDir=${sortDir}">Last</a>
			    </li>
			</ul>
		</nav>
	</main>

	<footer class="bg-light fixed-bottom py-3 text-center">
		<div class="container-fluid">
			<span class="text-muted">
				CMA made with JAVA11  &#129392;  
				<fmt:formatDate type = "date" pattern="dd.MM.yyyy"  value="${now}" />
			</span>
		</div>
	</footer>
	
	
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
	<script src="${contextPath}/resources/js/script.js"></script>
</body>
</html>