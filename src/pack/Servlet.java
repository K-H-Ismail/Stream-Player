package pack;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static final String ATT_CLIENT = "compte";
	public static final String ATT_FORM = "form";

	public static final String VUE = "index.html";
	public static final String VUE_FORM = "signup/signupError.jsp";
	public static final String VUE_ERR_CO = "signup/loginInvalid.jsp";
	public static final String VUE_PERSO = "pagePerso/pagePerso1.jsp";

	public static final String ATT_USER = "utilisateur";
	public static final String ATT_SESSION_USER = "sessionUtilisateur";

	@EJB
	Facade facade = new Facade();

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Servlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String op = request.getParameter("op");
		ServletContext context = getServletContext();
		context.log("This is a log item");

		if (op.equals("ajoutCompte")) {

			/* Préparation de l'objet formulaire */
			CreationCompte form = new CreationCompte();

			/* Traitement de la requête et récupération du bean résultant */
			Compte compte = form.creerCompte(request);

			/* Ajout du bean et de l'objet métier à l'objet requête */
			//request.setAttribute(ATT_CLIENT, compte);
			//request.setAttribute(ATT_FORM, form);

			if (form.getErreurs().isEmpty()) {
				facade.ajoutCompte(compte);
				/* Si aucune erreur, alors retour à la page d'accueil */
				request.getRequestDispatcher(VUE).forward(request, response);
			} else {
				/* Sinon, ré-affichage du formulaire de création avec les erreurs */
				request.getRequestDispatcher(VUE_FORM).forward(request, response);
			}
		}

		if (op.equals("connection")) {

			/* Préparation du formulaire */
			ConnexionCompte form = new ConnexionCompte();

			/* Traitement de la requête et récupération du bean résultant */
			Utilisateur utilisateur = form.connecterUtilisateur(request);

			facade.verifierCompte(utilisateur);

			if (utilisateur.isValid()) {

				/* Récupération de la session depuis la requête */
				HttpSession session = request.getSession();

				/* Ajout du bean Utilisateur à la session*/
				session.setAttribute(ATT_SESSION_USER, utilisateur);

				/* Stockage du formulaire et du bean dans l'objet request */
				//request.setAttribute(ATT_FORM, form);
				//request.setAttribute(ATT_USER, utilisateur);

				request.getRequestDispatcher(VUE_PERSO).forward(request, response);

			} else {
				request.getRequestDispatcher(VUE_ERR_CO).forward(request, response);
			}
		}

		if (op.equals("add_friend")) {

			/* Récupération de la session depuis la requête */
			HttpSession session = request.getSession();

			Utilisateur utilisateur = (Utilisateur)session.getAttribute(ATT_SESSION_USER);
			Compte c = facade.chercherCompte(utilisateur);

			String login = request.getParameter("login");
			Compte a_ajouter = facade.chercherCompte(login);

			/* ajout du compte ami */
			c.setAmi(a_ajouter);

			response.sendRedirect(request.getContextPath()+"/pagePerso/pagePerso1.jsp");

		}

		if (op.equals("logout")) {

			/* Récupération et destruction de la session en cours */
			HttpSession session = request.getSession();
			session.invalidate();

			/* Redirection vers la page d'accueil */
			response.sendRedirect(request.getContextPath() + "/" + VUE);
		}
	}

}
