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
		<h1>edition fournisseur</h1>
		<c:if test="${error != null}">
			<div class="alert alert-danger">il manque des informations
				obligatoire</div>
		</c:if>
		<div>
			<form action="fournisseur" method="get">
				<input type="hidden" name="query" value="save">
				<div class="form-group">
					<label for="id">id:</label> <input id="id" name="id"
						class="form-control" readonly="readonly" value="${fournisseur.id}"
						placeholder="generation auto">
				</div>
				<div class="form-group">
					<label for="civilite">civilite:</label> <select
						class="form-control" name="civilite">
						<c:forEach var="civilite" items="${civilites}">
							<option value="${civilite}">${civilite.titre}</option>
						</c:forEach>
					</select>
				</div>
				<div class="form-group">
					<label for="prenom">prenom:</label> <input id="prenom"
						name="prenom" class="form-control" value="${fournisseur.prenom}">
				</div>
				<div class="form-group">
					<label for="nom">nom:</label> <input id="nom" name="nom"
						class="form-control" value="${fournisseur.nom}">
				</div>
				<div class="form-group">
					<label for="commentaire">commentaire:</label>
					<textarea rows="10" cols="100" name="commentaire" id="commentaire"
						class="form-control">
						${fournisseur.commentaire}
					</textarea>
				</div>
				<div class="form-group">
					<label for="dateNaissance">date de naissance:</label> <input
						type="date" id="dateNaissance" name="dateNaissance"
						class="form-control" value="${fournisseur.dateNaissance}">
				</div>
				<div>
					<button type="submit" class="btn btn-outline-primary">enregistrer</button>
					<a href="fournisseur" class="btn btn-outline-warning">annuler</a>
				</div>
			</form>
		</div>
	</div>
</body>
</html>