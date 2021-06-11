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
<script
	src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"
	integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p"
	crossorigin="anonymous"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
	integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
	crossorigin="anonymous"></script>
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="container">
		<h1>edition produit</h1>
		<form:form action="save" method="get" modelAttribute="produit">
			<div class="form-group">
				<form:label path="id">id</form:label>
				<form:input path="id" cssClass="form-control" readonly="true"
					placeholder="generation auto" />
			</div>
			<div class="form-group">
				<form:label path="nom">nom</form:label>
				<form:input path="nom" cssClass="form-control" />
				<form:errors path="nom" cssClass="alert alert-danger" element="div">

				</form:errors>
			</div>
			<div class="form-group">
				<form:label path="prix">prix</form:label>
				<form:input type="number" path="prix" cssClass="form-control"
					step="0.1" />
				<form:errors path="prix" cssClass="alert alert-danger" element="div"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="fournisseur">fournisseur</form:label>
				<form:select path="fournisseur.id" cssClass="form-control">
					<form:option value="">pas de fournisseur</form:option>
					<form:options items="${fournisseurs}" itemValue="id"
						itemLabel="infos" />
				</form:select>
				<form:errors path="fournisseur"></form:errors>
			</div>
			<div>
				<button type="submit" class="btn btn-primary">enregister</button>
				<a href="list" class="btn btn-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>