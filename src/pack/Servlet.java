package pack;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.ejb.EJB;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Servlet
 */
@WebServlet(urlPatterns = { "/Servlet" }, 
			initParams = { @WebInitParam(name = "chemin", value = "/tmp/") })
@MultipartConfig(location = "/tmp/", 
				 fileSizeThreshold = 1024 * 1024,
				 maxFileSize = 1024 * 1024 * 5,
				 maxRequestSize = 1024 * 1024 * 5 * 5)
public class Servlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public static final String CHEMIN = "chemin";

	public static final String COMPTE = "compte";
	public static final String FORM = "form";
	public static final String USER = "utilisateur";
	public static final String SESSION_USER = "sessionUtilisateur";
	public static final String FICHIER = "fichier";

	public static final String VUE_ACCUEIL = "index.html";

	public static final String VUE_ERR_FORM = "signup/signupError.jsp";
	public static final String VUE_ERR_CO = "signup/loginInvalid.jsp";
	public static final String VUE_ERR_UPLOAD = "pagePerso/uploadError.jsp";

	public static final String VUE_PERSO = "pagePerso/pagePerso1.jsp";
	public static final String VUE_PROFIL = "pagePerso/profile.jsp";
	public static final String VUE_CATEGORIE = "pagePerso/ajoutCategorie.html";
	public static final String VUE_CREER_SALON = "pagePerso/creerSalon.jsp";
	public static final String VUE_JOIN_SALON = "pagePerso/rejoindreSalon.jsp";
	public static final String VUE_UPLOAD = "pagePerso/upload.jsp";

	@EJB
	Facade facade = new Facade();
	@EJB
	FacadeChat facadeChat = new FacadeChat();

	SimpleDateFormat formatHeure = new SimpleDateFormat("HH:mm");
	Indicateur ind = new Indicateur();

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


		if (op.equals("ajoutCompte")) {

			/* Préparation de l'objet formulaire */
			CreationCompte form = new CreationCompte();

			/* Traitement de la requête et récupération du bean résultant */
			Compte compte = form.creerCompte(request);

			if (facade.existeLogin(compte))
				form.setErreur("login", "Veuillez saisir un autre login.");

			/* Ajout du bean Compte et le formulaire à l'objet requête */
			request.setAttribute(COMPTE, compte);
			request.setAttribute(FORM, form);

			if (form.getErreurs().isEmpty()) {
				facade.ajoutCompte(compte);
				/* Si aucune erreur, alors retour à la page d'accueil */
				request.getRequestDispatcher(VUE_ACCUEIL).forward(request, response);
			} else {
				/* Sinon, ré-affichage du formulaire de création avec les erreurs */
				request.getRequestDispatcher(VUE_ERR_FORM).forward(request, response);
			}
		}

		if (op.equals("connexion")) {

			/* Préparation du formulaire */
			ConnexionCompte form = new ConnexionCompte();

			/* Traitement de la requête et récupération du bean résultant */
			Utilisateur utilisateur = form.connecterUtilisateur(request);

			/* Vérifie si l'existence du compte */
			facade.verifierCompte(utilisateur);

			if (utilisateur.isValid()) {

				facade.ajoutUtilisateur(utilisateur);

				/* Récupération de la session depuis la requête */
				HttpSession session = request.getSession();

				/* Ajout des beans Utilisateur/Compte à la session */
				session.setAttribute(SESSION_USER, utilisateur);
				Compte compte = facade.chercherCompte(utilisateur);
				session.setAttribute(COMPTE, compte);

				/* Stockage du formulaire et du bean dans l'objet request */
				request.setAttribute(FORM, form);
				request.setAttribute(USER, utilisateur);

				request.getRequestDispatcher(VUE_PERSO).forward(request, response);

			} else {
				request.getRequestDispatcher(VUE_ERR_CO).forward(request, response);
			}
		}

		if (op.equals("souscrire")) {

			/* Récupération de la session depuis la requête */
			HttpSession session = request.getSession();

			/* Récupération du compte associé à l'utilisateur */
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(SESSION_USER);
			Compte compteCourant = facade.chercherCompte(utilisateur);

			/* Recherche du compte associé au login donné */
			String login = request.getParameter("login");
			Compte compteSouscrit = facade.chercherCompte(login);

			/* Souscription à un nouveau compte */
			facade.associer(compteCourant.getId(), compteSouscrit.getId());

			session.setAttribute(COMPTE, compteCourant);

			request.getRequestDispatcher(VUE_PERSO).forward(request, response);
		}
		
		if (op.equals("profile")) {
			
			/* Récupération de la session depuis la requête */
			HttpSession session = request.getSession();
			Utilisateur utilisateur = (Utilisateur) session.getAttribute(SESSION_USER);
			Compte compteCourant = facade.chercherCompte(utilisateur);
			request.setAttribute("compte",compteCourant);
			request.getRequestDispatcher(VUE_PROFIL).forward(request, response);
		}

		if (op.equals("upload")) {

			/* Lecture du paramètre 'chemin' passé à la servlet via @WebInitParam */
			String chemin = this.getServletConfig().getInitParameter(CHEMIN);

			/* Préparation de l'objet formulaire */
			UploadFichier form = new UploadFichier();

			/* Traitement de la requête et récupération du bean résultant */
			Fichier fichier = form.enregistrerFichier(request, chemin);
			
			request.setAttribute(FORM, form);
			request.setAttribute(FICHIER, fichier);

			if (form.getErreurs().isEmpty()) {
				
				HttpSession session = request.getSession();

				Utilisateur utilisateur = (Utilisateur) session.getAttribute(SESSION_USER);
				Compte compteCourant = facade.chercherCompte(utilisateur);

				facade.ajoutFichier(fichier, compteCourant.getId());			
				
				request.getRequestDispatcher(VUE_PERSO).forward(request, response);
			} else {
				request.getRequestDispatcher(VUE_ERR_UPLOAD).forward(request, response);
			}

		}

		if (op.equals("pageCategorie")) {

			request.getRequestDispatcher(VUE_CATEGORIE).forward(request, response);
		}

		if (op.equals("ajoutCategorie")) {

			/* Récupération de la nouvelle Catégorie */
			String cat = request.getParameter("categorie");
			Categorie categorie = new Categorie(cat);
			facade.ajoutCategorie(categorie);
			request.setAttribute("listeC", facade.listeCategorie());
			request.getRequestDispatcher(VUE_CREER_SALON).forward(request, response);
		}

		if (op.equals("ajoutSalon")) {

			HttpSession session = request.getSession();

			Utilisateur utilisateur = (Utilisateur) session.getAttribute(SESSION_USER);
			Compte compteCourant = facade.chercherCompte(utilisateur);

			/* Récupération du nouveau Salon */
			String nom = request.getParameter("nom");
			String lien = request.getParameter("lien");
			String[] categories = request.getParameterValues("categorie");
			List<Categorie> catlist = new ArrayList<Categorie>();
			for (String categorie : categories) {
				Categorie cat = facade.chercherCategorie(categorie);
				catlist.add(cat);
			}
			Salon salon = new Salon(nom, lien, catlist);

			facade.ajoutSalon(salon, compteCourant.getId());
			session.setAttribute(COMPTE, compteCourant);
			request.getRequestDispatcher(VUE_PERSO).forward(request, response);
		}

		if (op.equals("creerSalon")) {

			request.setAttribute("listeC", facade.listeCategorie());
			request.getRequestDispatcher(VUE_CREER_SALON).forward(request, response);
		}

		if (op.equals("rejoindreSalon")) {

			request.setAttribute("listeS", facade.listeSalon());
			request.getRequestDispatcher(VUE_JOIN_SALON).forward(request, response);
		}


		if (op.equals("logout")) {

			/* Récupération et destruction de la session en cours */
			HttpSession session = request.getSession();
			session.invalidate();

			/* Redirection vers la page d'accueil */
			response.sendRedirect(request.getContextPath() + "/" + VUE_ACCUEIL);
		}

		if (op.equals("connectChat")) {
			request.setAttribute("listeMessage", facadeChat.messages());
			request.setAttribute("nvMessage", ind);
			request.getRequestDispatcher("chat/chatBox.jsp").forward(request, response);
		}

		if (op.equals("newMsg")) {
			Date now = new Date();
			String message = request.getParameter("message");
			String user = request.getParameter("pseudo");
			String heure = formatHeure.format(now);
			facadeChat.ajoutMessage(new Message(user, message, heure));
			response.setContentType("text/xml");
			response.getWriter().write("<div class=\"message\" name=\"messageName\"> ("+heure+") <B>"+user+"</B> : "+message+" </div>");
		}
		if (op.equals("refresh")){
			//request.setAttribute("nvMessage",ind);		
			//request.setAttribute("listeMessage", facadeChat.messages());			
			//request.getRequestDispatcher("chat/chatBox.jsp").forward(request, response);
			response.setContentType("text/xml");
			int indice = Integer.parseInt(request.getParameter("ind"));
			Collection <Message> listeMessage = facadeChat.messagesInd(indice); 
			String nvMessages = new String() ;
			String message;
			String user;
			String heure;
			for (Message msg : listeMessage){
				heure = msg.getDate();
				user = msg.getUser();
				message = msg.getText();
				nvMessages +="<div class=\"message\" name=\"messageName\"> ("+heure+") <B>"+user+"</B> : "+message+" </div>";
			}
			response.getWriter().write(nvMessages);
		}

		if (op.equals("nbMessage")){
			int size;
			Collection <Message> listeMessage = facadeChat.messages(); 	
			if (listeMessage==null){
				size = 0;
			}else{
				size=listeMessage.size();
			}
			response.setContentType("text/xml");
			response.getWriter().write(Integer.toString(size));
		}
		
	}

}
