<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x"
	crossorigin="anonymous">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h1>liste des produits</h1>
		<c:if test="${param.create!=null}">
			<div class="alert alert-info">produit ${param.create} créé</div>
		</c:if>
		<c:if test="${param.update!=null}">
			<div class="alert alert-info">produit ${param.update} modifié</div>
		</c:if>
		<c:if test="${param.delete!=null}">
			<div class="alert alert-info">produit ${param.delete} supprimé</div>
		</c:if>
		<table class="table">
			<tr>
				<th>id</th>
				<th>nom</th>
				<th>prix</th>
				<th>fournisseur</th>

				<th></th>
			</tr>
			<c:forEach var="p" items="${produits}">
				<tr>
					<td>${p.id}</td>
					<td>${p.nom}</td>
					<td>${p.prix}</td>
					<td>${p.fournisseur.infos}</td>
					<td><a href="edit?id=${p.id}" class="btn btn-primary">editer</a></td>
					<td><a href="delete?id=${p.id}" class="btn btn-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="add" class="btn btn-link">ajouter</a>
	</div>
</body>
</html>