<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="fn"   uri="http://java.sun.com/jsp/jstl/functions"  %>

<!DOCTYPE html>
<html>
<head>
	<title>Save Customer</title>
	<meta charset="UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.1/css/all.min.css" rel="stylesheet">
</head>
<body>
	
	<div class="container">
		<h3 class="h4 mt-4 mb-4">Save Customer</h3>
		
		<hr>

		<form:form action="save" method="POST" modelAttribute="customer">
			<form:hidden path="id"/>
			
			<div class="form-group row mt-4 mb-4">
				<label for="firstName" class="col-sm-2 col-form-label">First name:</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="firstName" id="firstName" />
				</div>
			</div>
			
			<div class="form-group row mt-4 mb-4">
				<label for="lastName" class="col-sm-2 col-form-label">Last name:</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="lastName" id="lastName" />
				</div>
			</div>
			
			<div class="form-group row mt-4 mb-4">
				<label for="email" class="col-sm-2 col-form-label">Email:</label>
				<div class="col-sm-4">
					<form:input class="form-control" path="email" id="email" />
				</div>
			</div>
			
			<button type="submit" class="btn btn-info col-1">Save</button>
		</form:form>
		
		<hr>
		
		<a href="">Back to Customer List</a>
		
		<footer class="bg-light fixed-bottom py-3 text-center">
			<div class="container-fluid">
				<span class="text-muted">CMA made with JAVA11  &#129392;  25.06.2022</span>
			</div>
		</footer>
	</div>
</body>
</html>