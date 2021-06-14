<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath }" />
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
	<jsp:include page="./menu.jsp"></jsp:include>
	<div class="container">
		<h1>identification</h1>
		<c:if test="${param.error != null }">
			<div class="alert alert-danger">erreur d'authentification</div>
		</c:if>
		<form method="post" action="">
			<input type="hidden" name="${_csrf.parameterName}"
				value="${_csrf.token}">
			<div class="form-group">
				<label for="username">login:</label> <input name="username"
					id="username" required="required"
					placeholder="saisir votre nom d'utilisateur" class="form-control">
			</div>
			<div class="form-group">
				<label for="password">login:</label> <input type="password"
					id="password" name="password" required="required"
					placeholder="saisir votre mot de passe" class="form-control">
			</div>
			<div class="form-group">
				<button type="submit" class="btn btn-primary">envoyer</button>
				<a href="${ctx}" class="btn btn-warning">annuler</a>
			</div>
		</form>
	</div>
</body>
</html>