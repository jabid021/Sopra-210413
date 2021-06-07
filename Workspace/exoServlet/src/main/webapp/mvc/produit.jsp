<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div>
		<%
		if (request.getParameter("error") != null) {
		%>
		<div style="color: red">donnees incorrectes</div>
		<%
		}
		%>
		<form action="produit" method="get">
			nom:<input name="nom" required="required"><br> prix:<input
				type="number" name="prix" required="required"><br>
			<button type="submit">enregistrer</button>
		</form>
	</div>
</body>
</html>