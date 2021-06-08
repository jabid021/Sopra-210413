package exoJpaspringVue.controller;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;

import exoJpaSpring.entity.Civilite;
import exoJpaSpring.entity.Fournisseur;
import exoJpaSpring.exceptions.FournisseurException;
import exoJpaSpring.services.FournisseurService;

/**
 * Servlet implementation class FournisseurController
 */
@WebServlet("/fournisseur")
public class FournisseurController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private ApplicationContext ctx;
	private FournisseurService fournisseurService;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public FournisseurController() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init() throws ServletException {
		ctx = (ApplicationContext) this.getServletContext().getAttribute("spring");
		fournisseurService = ctx.getBean(FournisseurService.class);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		RequestDispatcher rd = null;
		if (request.getParameter("query") == null) {
			rd = list(request, response);
		} else if (request.getParameter("query").equals("delete")) {
			// suppression
			rd = delete(request, response);
		} else if (request.getParameter("query").equals("edit")) {
			// edition
			rd = edit(request, response);
		} else if (request.getParameter("query").equals("add")) {
			// ajout
			rd = add(request, response);
		} else if (request.getParameter("query").equals("save")) {
			// sauvegarde
			rd = save(request, response);
		}
		rd.forward(request, response);
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

	private RequestDispatcher list(HttpServletRequest request, HttpServletResponse response) {
		request.setAttribute("fournisseurs", fournisseurService.getAll());
		return request.getRequestDispatcher("/WEB-INF/fournisseur/list.jsp");
	}

	private RequestDispatcher delete(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		fournisseurService.delete(id);
		return list(request, response);
	}

	private RequestDispatcher goEdit(HttpServletRequest request, HttpServletResponse response,
			Fournisseur fournisseur) {
		request.setAttribute("fournisseur", fournisseur);
		request.setAttribute("civilites", Civilite.values());
		return request.getRequestDispatcher("/WEB-INF/fournisseur/edit.jsp");
	}

	private RequestDispatcher add(HttpServletRequest request, HttpServletResponse response) {
		return goEdit(request, response, new Fournisseur());
	}

	private RequestDispatcher edit(HttpServletRequest request, HttpServletResponse response) {
		Integer id = Integer.parseInt(request.getParameter("id"));
		return goEdit(request, response, fournisseurService.getById(id));
	}

	private RequestDispatcher save(HttpServletRequest request, HttpServletResponse response) {
		Fournisseur f = new Fournisseur();
		String prenom = request.getParameter("prenom");
		f.setPrenom(prenom);
		String nom = request.getParameter("nom");

		f.setNom(nom);
		f.setCivilite(Civilite.valueOf(request.getParameter("civilite")));

		f.setCommentaire(request.getParameter("commentaire"));
		String dateNaissance = request.getParameter("dateNaissance");
		if (dateNaissance != null && !dateNaissance.isEmpty()) {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			f.setDateNaissance(LocalDate.parse(dateNaissance, formatter));
		}
		Integer id;
		if (request.getParameter("id") == null || request.getParameter("id").isEmpty()) {
			id = null;
		} else {
			id = Integer.parseInt(request.getParameter("id"));
		}
		f.setId(id);
		if (nom == null || nom.isEmpty()) {
			// erreur
			// traitement bloquant
			request.setAttribute("error", "nom obligatoire");
			return goEdit(request, response, f);
		}
		try {
			fournisseurService.save(f);
		} catch (FournisseurException e) {
			e.printStackTrace();
		}
		return list(request, response);

	}

}
