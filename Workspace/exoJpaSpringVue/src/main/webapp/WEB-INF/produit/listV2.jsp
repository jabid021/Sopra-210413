<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
		<table class="table">
			<tr class="table-primary">
				<th>id:</th>
				<th>nom:</th>
				<th>prix:</th>
				<th>fournisseur:</th>
			</tr>
			<c:forEach var="produit" items="${produits}">
				<tr>
					<td>${produit.id}</td>
					<td>${produit.nom}</td>
					<td>${produit.prix}</td>
					
					<td><a href="produit?q=edit&id=${produit.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="produit?q=delete&id=${produit.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="produit?q=add" class="btn btn-link">ajouter un produit</a>
	</div>
</body>
</html>