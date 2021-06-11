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
	<div class=container>
		<h1>votre panier</h1>
		<table class="table">
			<tr>
				<th>produit</th>
				<th>prix unitaire</th>
				<th>quantite</th>
				<th>total</th>
				<th></th>
				<c:set var="total" value="0"></c:set>
				<c:forEach var="produit" items="${panier.keySet()}">
					<tr>
						<td>${produit.nom}</td>
						<td>${produit.prix}</td>
						<td>${panier.get(produit)}</td>
						<td>${produit.prix * panier.get(produit) }€</td>
						<td><a href="remove?id=${produit.id}" class="btn btn-danger">retirer
								du panier</a></td>
					</tr>
					<c:set var="total"
						value="${total + produit.prix * panier.get(produit)}"></c:set>
				</c:forEach>
		</table>
		<div>prix total du panier:${total}€</div>
		<a href="panier" class="btn btn-link">retour à la liste des
			produit</a> <a href="valid" class="btn btn-link">valider la commande</a><a href="cancel" class="btn btn-outline-danger">annuler la commande</a>
	</div>
</body>
</html>