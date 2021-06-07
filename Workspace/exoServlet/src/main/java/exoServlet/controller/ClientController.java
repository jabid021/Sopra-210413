package exoServlet.controller;

import java.io.IOException;
import java.net.Authenticator.RequestorType;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import exoServlet.model.Civilite;
import exoServlet.model.Client;

/**
 * Servlet implementation class ClientController
 */
@WebServlet("/client")
public class ClientController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ClientController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String prenom = request.getParameter("prenom");
		String nom = request.getParameter("nom");
		RequestDispatcher rd = null;
		boolean error = false;
		if (prenom == null || prenom.isEmpty() || nom == null || nom.isEmpty()) {
			error = true;
		} else if (request.getParameter("civilite") == null) {
			error = true;
		}
		if (error) {
			rd = request.getRequestDispatcher("/client.jsp?error=");
		} else {
			Client client = new Client(prenom, nom, Civilite.valueOf(request.getParameter("civilite")));
			request.setAttribute("client", client);
			rd = request.getRequestDispatcher("/WEB-INF/info-client.jsp");
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

}
