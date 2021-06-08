package exoJpaspringVue.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import exoJpaSpring.config.AppConfig;
import exoJpaSpring.entity.Produit;
import exoJpaSpring.exceptions.FournisseurException;
import exoJpaSpring.exceptions.ProduitException;
import exoJpaSpring.services.ProduitService;

/**
 * Servlet implementation class ProduitController
 */
@WebServlet("/produit")
public class ProduitController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private AnnotationConfigApplicationContext ctx;
	private ProduitService produitService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ProduitController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		ctx = (AnnotationConfigApplicationContext) this.getServletContext().getAttribute("spring");
		produitService = ctx.getBean(ProduitService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (request.getParameter("q") == null) {
			rd = list(request, response);
		} else if (request.getParameter("q").equals("delete")) {
			rd = delete(request, response);
		} else if (request.getParameter("q").equals("edit")) {
			rd = edit(request, response);
		} else if (request.getParameter("q").equals("add")) {
			rd = goEdit(request, response, new Produit());
		} else if (request.getParameter("q").equals("save")) {
			rd = save(request, response);
		}
		rd.forward(request, response);

	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		String nom = request.getParameter("nom");
		Integer id = null;
		if (request.getParameter("id") != null && !request.getParameter("id").isEmpty()) {
			id = Integer.parseInt(request.getParameter("id"));
		}
		double prix = 0;
		if (request.getParameter("prix") != null && !request.getParameter("prix").isEmpty()) {
			prix = Double.parseDouble(request.getParameter("prix"));
		}

		Produit produit = new Produit(nom, prix);
		if (id != null) {
			produit.setId(id);
		}
		try {
			produitService.save(produit);
		} catch (Exception e) {

		}
		return list(request, response);
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		RequestDispatcher rd = null;
		try {
			rd = goEdit(request, response, produitService.getById(id));
		} catch (ProduitException e) {
			rd = goEdit(request, response, new Produit());
		}
		return rd;
	}

	private RequestDispatcher goEdit(HttpServletRequest request, HttpServletResponse response, Produit produit) {
		request.setAttribute("produit", produit);
		return request.getRequestDispatcher("/WEB-INF/produit/edit.jsp");
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		produitService.delete(id);
		return list(request, response);

	}

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("produits", produitService.getAll());
		return request.getRequestDispatcher("/WEB-INF/produit/listV2.jsp");
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
