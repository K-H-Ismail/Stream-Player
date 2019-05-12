package pack;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public final class CreationCompte {
	private static final String CHAMP_login = "login";
	private static final String CHAMP_password = "password";
	private static final String CHAMP_EMAIL = "email";

	private String resultat;
	private Map<String, String> erreurs = new HashMap<String, String>();

	public Map<String, String> getErreurs() {
		return erreurs;
	}

	public String getResultat() {
		return resultat;
	}

	public Compte creerCompte(HttpServletRequest request) {
		String login = getValeurChamp(request, CHAMP_login);
		String password = getValeurChamp(request, CHAMP_password);
		String email = getValeurChamp(request, CHAMP_EMAIL);

		Compte compte = new Compte();

		try {
			validationLogin(login);
		} catch (Exception e) {
			setErreur(CHAMP_login, e.getMessage());
		}
		compte.setLogin(login);

		try {
			validationPassword(password);
		} catch (Exception e) {
			setErreur(CHAMP_password, e.getMessage());
		}
		compte.setPassword(password);

		try {
			validationEmail(email);
		} catch (Exception e) {
			setErreur(CHAMP_EMAIL, e.getMessage());
		}
		compte.setEmail(email);

		if (erreurs.isEmpty()) {
			resultat = "Succès de la création du compte.";
		} else {
			resultat = "Échec de la création du compte.";
		}

		return compte;
	}

	private void validationLogin(String login) throws Exception {
		if (login != null) {
			if (login.length() < 2) {
				throw new Exception("Le login doit contenir au moins 2 caractères.");
			}
		} else {
			throw new Exception("Merci d'entrer un login.");
		}
	}

	private void validationPassword(String password) throws Exception {
		if (password != null) {
			if (password.length() < 2) {
				throw new Exception("Le mot de passe doit contenir au moins 2 caractères.");
			}
			
		} else {
			throw new Exception("Merci de saisir un mot de passe.");
		}
	}

	private void validationEmail(String email) throws Exception {
		if (email != null) {
			if(!email.matches("([^.@]+)(\\.[^.@]+)*@([^.@]+\\.)+([^.@]+)")) {
				throw new Exception("Merci de saisir une adresse mail valide.");
			}
		} else {
			throw new Exception("Merci d'entrer une adresse mail.");
		}
	}

	/*
	 * Ajoute un message correspondant au champ spécifié à la map des erreurs.
	 */
	private void setErreur(String champ, String message) {
		erreurs.put(champ, message);
	}

	/*
	 * Méthode utilitaire qui retourne null si un champ est vide, et son contenu
	 * sinon.
	 */
	private static String getValeurChamp(HttpServletRequest request, String loginChamp) {
		String valeur = request.getParameter(loginChamp);
		if (valeur == null || valeur.trim().length() == 0) {
			return null;
		} else {
			return valeur;
		}
	}
}