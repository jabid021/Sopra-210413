<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>
		bonjour
		<%
	if (request.getParameter("prenom") != null) {
	%>
		<%=request.getParameter("prenom").toUpperCase()%></h1>
	<%
	}
	%>
</body>
</html>