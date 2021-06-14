<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
	<form:form action="personne" method="post" modelAttribute="personne">
		<div class="form-group">
			<form:label path="prenom">prenom:</form:label>
			<form:input path="prenom" cssClass="form-control" />
		</div>
		<div>
			<form:label path="nom">nom:</form:label>
			<form:input path="nom" cssClass="form-control" />
		</div>
		<button type="submit" class="btn ">envoyer</button>
	</form:form>
</body>
</html>