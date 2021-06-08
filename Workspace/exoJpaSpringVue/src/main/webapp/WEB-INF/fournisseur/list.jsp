<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
		<h1>liste des fournisseurs</h1>
		<table class="table">
			<tr>
				<th>id</th>
				<th>civilite</th>
				<th>prenom</th>
				<th>nom</th>
				<th>contact</th>
				<th>date de naissance</th>
				<th>commentaire</th>
				<th></th>
				<th></th>
			</tr>
			<c:forEach var="f" items="${fournisseurs}">
				<tr>
					<td>${f.id}</td>
					<td>${f.civilite.titre }</td>
					<td>${f.prenom}</td>
					<td>${f.nom}</td>
					<td>${f.contact}</td>
					<td><fmt:parseDate value="${f.dateNaissance}"
							pattern="yyyy-MM-dd" var="javaUtilDate"></fmt:parseDate> <fmt:formatDate
							value="${javaUtilDate}" pattern="dd/MM/yyyy" /></td>
					<td>${f.commentaire}</td>
					<td><a href="fournisseur?query=edit&id=${f.id}"
						class="btn btn-outline-primary">editer</a></td>
					<td><a href="fournisseur?query=delete&id=${f.id}"
						class="btn btn-outline-danger">supprimer</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="fournisseur?query=add" class="btn btn-link">ajouter un
			fournisseur</a>
	</div>
</body>
</html>