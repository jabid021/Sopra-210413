<%@page import="exoServlet.model.Produit"%>
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
		infos produit saisie:
		<%=((Produit) request.getAttribute("produit")).getNom()%>
		${produit.prix}<br> avec la methode Infos:${produit.infos}
	</div>
</body>
</html>