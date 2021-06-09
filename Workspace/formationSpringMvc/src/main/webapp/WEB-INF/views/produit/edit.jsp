<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>edition produit</h1>
		<form:form action="save" method="post" modelAttribute="produit">
			<div class="form-group">
				<form:label path="id">id</form:label>
				<form:input path="id" cssClass="form-control" readonly="true"
					placeholder="generation auto" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom</form:label>
				<form:input path="nom" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="prix">prix</form:label>
				<form:input type="number" path="prix" cssClass="form-control" />
			</div>
			<div>
				<button type="submit" class="btn btn-primary">enregister</button>
				<a href="list" class="btn btn-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>