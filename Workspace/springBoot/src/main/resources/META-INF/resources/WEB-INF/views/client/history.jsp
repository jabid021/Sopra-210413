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
		<h1>historique des commandes de ${client.civilite.titre}
			${client.prenom} ${client.nom}</h1>
		<table class="table">
			<tr>
				<th>numero</th>
				<th>date</th>
				<th></th>
			</tr>
			<c:forEach var="commande" items="${client.commandes}">
				<tr>
					<td>${commande.numero}</td>
					<td><fmt:parseDate value="${commande.date}"
							pattern="yyyy-MM-dd" var="javaUtilDate"></fmt:parseDate> <fmt:formatDate
							value="${javaUtilDate}" pattern="dd/MM/yyyy" /></td>
					<td><a href="history/details?numero=${commande.numero}"
						class="btn btn-link">details</a></td>
			</c:forEach>
		</table>
		<a href="list" class="btn btn-link">retour</a>
	</div>
</body>
</html>