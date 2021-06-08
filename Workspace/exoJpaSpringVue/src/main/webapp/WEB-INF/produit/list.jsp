<%@page import="exoJpaSpring.entity.Produit"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
			<%
			List<Produit> produits = (List<Produit>) request.getAttribute("produits");
			for (Produit p : produits) {
			%>
			<tr>
				<td><%=p.getId()%></td>
				<td><%=p.getNom()%></td>
				<td><%=p.getPrix()%></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>