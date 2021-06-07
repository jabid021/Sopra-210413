package exoServlet.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import exoServlet.model.Produit;

/**
 * Servlet implementation class ProduitServlet
 */
@WebServlet("/produit")
public class ProduitServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		out.append("<!DOCTYPE html>\n" + "<html>\n" + "<head>\n" + "<meta charset=\"UTF-8\">");
		out.append("<title>produit</title>");
		out.append("<body>");
		ServletContext servletContext = this.getServletContext();
		if (servletContext.getAttribute("compteur") == null) {
			servletContext.setAttribute("compteur", 0);
		}
		Integer compteur = (Integer) servletContext.getAttribute("compteur");
		compteur++;

		servletContext.setAttribute("compteur", compteur);
		out.append("<div>nombre de requete recu pour cette page " + compteur + "</div>");

		String nom = request.getParameter("nom");
		int prix = 0;
		boolean error = false;
		if (nom == null || nom.equals("")) {
			// nom pas renseigné
			error = true;
		} else if (request.getParameter("prix") == null) {
			// prix pas renseigné
			error = true;
		} else {
			try {
				// pas un nombre
				prix = Integer.parseInt(request.getParameter("prix"));
			} catch (NumberFormatException e) {
				error = true;
			}
		}

		if (error) {
			out.append("<div>donnees incorrectes</div>");
		} else {
			Produit produit = new Produit(nom, prix);
			// stockage du produit dans la session
			HttpSession session = request.getSession();
			session.setAttribute("produit", produit);

			Cookie cookie = new Cookie("produit", produit.getNom() + ":" + produit.getPrix());
			cookie.setMaxAge(3600 * 24 * 7);

			response.addCookie(cookie);
			out.append("<div>information produit saisie:" + produit.getNom() + " " + produit.getPrix() + "</div>");
		}
		out.append("</body></html>");

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
