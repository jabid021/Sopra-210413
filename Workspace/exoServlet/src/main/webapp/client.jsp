<%@page import="exoServlet.model.Civilite"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>saisie de client</h1>
	${error}
	<%
	if (request.getParameter("error") != null) {
	%>
	<div>erreur</div>
	<%
	}
	%>
	<form method="get" action="client">
		<div>
			prenom:<input name="prenom" required="required">
		</div>
		<div>
			nom:<input name="nom" required="required">
		</div>
		<div>
			titre:<select name="civilite">
				<%
				for (Civilite civilite : Civilite.values()) {
				%>
				<option value="<%=civilite%>"><%=civilite.getTitre()%></option>
				<%
				}
				%>
			</select>
		</div>
		<div>
			<button type="submit">enregistrer</button>
		</div>
	</form>
</body>
</html>