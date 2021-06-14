<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="container">
		<h1>selectionner vos produit</h1>
		<form:form action="add" method="post" modelAttribute="lc">
			<div class="form-group">
				<form:label path="key.produit">produit</form:label>
				<form:select path="key.produit.id" items="${produits}"
					itemValue="id" cssClass="form-control"></form:select>
			</div>
			<div class="form-group">
				<form:label path="quantite">quantite</form:label>
				<form:input path="quantite" cssClass="form-control" />
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">ajouter au
					panier</button>
			</div>
		</form:form>
		<a href="show" class="btn btn-link">consulter le panier</a>
	</div>
</body>
</html>