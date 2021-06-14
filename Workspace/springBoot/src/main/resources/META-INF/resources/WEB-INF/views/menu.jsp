<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.servletContext.contextPath }" />
<nav class="navbar navbar-expand-md navbar-light bg-primary">
	<div class="container-fluid">
		<a href="${ctx}" class="navbar-brand">mon site marchant</a>
		<button class="navbar-toggler" data-bs-toggle="collapse"
			data-bs-target="#navbarNav" aria-expanded="false">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarNav">
			<ul class="navbar-nav">
				<li class="nav-item"><a href="${ctx}" class="nav-link">accueil</a></li>
				<li class="nav-item"><a href="${ctx}/client" class="nav-link">
						gestion des clients</a></li>
				<li class="nav-item"><a href="${ctx}/produit" class="nav-link">gestion
						des produits </a></li>
				<li class="nav-item"><a href="${ctx}/fournisseur"
					class="nav-link">gestion des fournisseurs </a></li>
				<li class="nav-item"><a href="${ctx}/commande/panier"
					class="nav-link"> commander des produits </a></li>
			</ul>
		</div>
	</div>
</nav>
