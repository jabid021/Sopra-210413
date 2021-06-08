<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
		<form action="produit" method="post">
			<input type="hidden" name="q" value="save">
			<%-- 			<input type="hidden" name="version" value="${produit.version}"> --%>
			<div class="form-group">
				<label for="id">id:</label> <input id="id" name="id"
					class="form-control" value="${produit.id}" readonly="readonly"
					placeholder="génération automatique">
			</div>
			<div class="form-group">
				<label for="nom">nom:</label> <input id="nom" name="nom"
					class="form-control" value="${produit.nom}">
			</div>
			<div class="form-group">
				<label for="prix">prix:</label> <input id="prix" name="prix"
					type="number" class="form-control" value="${produit.prix}">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-outline-primary">enregistrer</button>
				<a href="produit" class="btn btn-outline-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>