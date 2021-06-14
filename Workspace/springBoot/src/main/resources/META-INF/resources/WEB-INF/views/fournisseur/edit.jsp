<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
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
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="../menu.jsp"></jsp:include>
	<div class="container">
		<h1>edition de fournisseur</h1>
		<form:form action="save" method="post" modelAttribute="fournisseur">
			<div class="form-group">
				<form:label path="id">id:</form:label>
				<form:input path="id" readonly="true" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="civilite">civilite</form:label>
				<form:select path="civilite" cssClass="form-control"
					items="${civilites}" itemLabel="titre">
					<%-- 					<form:options items="${civilites}"  itemLabel="titre"/> --%>
				</form:select>
			</div>

			<div class="form-group">
				<form:label path="prenom">prenom:</form:label>
				<form:input path="prenom" cssClass="form-control" />
				<form:errors path="prenom"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="nom">prenom:</form:label>
				<form:input path="nom" cssClass="form-control" />
				<form:errors path="nom"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="contact">contact:</form:label>
				<form:input type="email" path="contact" cssClass="form-control" />
				<form:errors path="contact"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="dateNaissance">date naissance:</form:label>
				<form:input type="date" path="dateNaissance" cssClass="form-control" />
				<form:errors path="dateNaissance"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="commentaire">commentaire:</form:label>
				<form:textarea path="commentaire" cssClass="form-control" />
			</div>
			<div class="form-group">
				<form:label path="adresse.numero">numero:</form:label>
				<form:input path="adresse.numero" cssClass="form-control" />
				<form:errors path="adresse.numero"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.rue">rue:</form:label>
				<form:input path="adresse.rue" cssClass="form-control" />
				<form:errors path="adresse.rue"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.codePostal">code postal:</form:label>
				<form:input path="adresse.codePostal" cssClass="form-control" />
				<form:errors path="adresse.codePostal"></form:errors>
			</div>
			<div class="form-group">
				<form:label path="adresse.ville">ville:</form:label>
				<form:input path="adresse.ville" cssClass="form-control" />
				<form:errors path="adresse.ville"></form:errors>
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">enregistrer</button>
				<a href="list" class="btn btn-warning">annuler</a>
			</div>
		</form:form>
	</div>
</body>
</html>