<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<div class="container">
		<h1>listes des fournisseurs</h1>
		<table class="table">
			<tr>
				<th>id</th>
				<th>prenom</th>
				<th>nom</th>
				<th>contact</th>
				<th>date de naissance</th>
				<th>adresse</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="f" items="${fournisseurs}">
				<tr>
					<td>${f.id}</td>
					<td>${f.prenom}</td>
					<td>${f.nom}</td>
					<td>${f.contact}</td>
					<td>${f.dateNaissance}</td>
					<td>${f.adresse.numero}&nbsp;${f.adresse.rue}<br>${f.adresse.codePostal}&nbsp;${f.adresse.ville}
					</td>
					<td><a href="edit?id=${f.id}" class="btn btn-primary">editer</a></td>
					<td><a href="delete?id=${f.id}" class="btn btn-danger">supprier</a></td>
			</c:forEach>
		</table>
		<a href="add" class="btn btn-link">ajout</a>
	</div>
</body>
</html>