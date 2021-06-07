package exoServlet.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exoServlet.model.Produit;

@WebServlet("/mvc/produit")
public class ProduitController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		boolean error = false;
		String nom = req.getParameter("nom");
		Integer prix = null;
		RequestDispatcher rd = null;
		if (nom == null || nom.isEmpty()) {
			error = true;
		} else if (req.getParameter("prix") == null) {
			error = true;
		} else {
			try {
				prix = Integer.parseInt(req.getParameter("prix"));
			} catch (NumberFormatException e) {
				error = true;
			}
		}

		if (error) {
			// erreur retour vers formulaire
			rd = req.getRequestDispatcher("/mvc/produit.jsp?error=error");
		} else {
			// pas erreur
			// creation modele
			req.setAttribute("produit", new Produit(nom, prix));
			// page d'affichage du produit
			rd = req.getRequestDispatcher("/WEB-INF/info-produit.jsp");
		}
		rd.forward(req, resp);
		// non traite
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}
