<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%!//declarative
	Integer n = 10;
	String texte = "yellow";

	String getTexte() {
		return texte;
	}%>
	<p>avant scriptlet</p>
	<%
	//scriplet
	if (n < 20) {
	%>
	<div>n&lt;20</div>
	<%
	}
	%>
	<p>apres scriptlet</p>
	<%
	out.write(getTexte());
	%>

	<div style="background-color: <%=getTexte()%>"><%=getTexte()%></div>
	<div>
		<h2>on joue avec des el</h2>
		<%
		Integer a = 1000;
		request.setAttribute("toto", a);
		request.setAttribute("texte", getTexte());
		%>
		<p>
			n:${toto} <br>${texte} ${param}
		</p>
	</div>
</body>
</html>