package pack;

import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Singleton
public class Facade {

	@PersistenceContext
	private EntityManager em;

	public void ajoutCompte(Compte c) {
		em.persist(c);
	}

	public void ajoutUtilisateur(Utilisateur u) {
		em.persist(u);
	}

	public void ajoutFichier(Fichier f, int compteId) {
		em.persist(f);
		Compte c = em.find(Compte.class, compteId);
		f.setProprietaire(c);
	}

	public void ajoutCategorie(Categorie cat) {
		em.persist(cat);
	}

	public void ajoutSalon(Salon s, int compteId) {
		em.persist(s);
		Compte c = em.find(Compte.class, compteId);
		Salon old = c.getSalon();
		if (old != null)
			old.setStreamer(null);
		s.setStreamer(c);
	}

	public Collection<Compte> listeCompte() {
		TypedQuery<Compte> req = em.createQuery("select c from Compte c", Compte.class);
		return req.getResultList();
	}

	public Collection<Categorie> listeCategorie() {
		TypedQuery<Categorie> req = em.createQuery("select c from Categorie c", Categorie.class);
		return req.getResultList();
	}

	public Collection<Salon> listeSalon() {
		TypedQuery<Salon> req = em.createQuery("select s from Salon s", Salon.class);
		return req.getResultList();
	}

	public void verifierCompte(Utilisateur utilisateur) {
		String login = utilisateur.getLogin();
		String password = utilisateur.getPassword();
		Query query = em.createQuery("select c from Compte c where c.login=:login and c.password=:password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		List<Compte> req = query.getResultList();
		if (req.isEmpty())
			utilisateur.setValid(false);
		else
			utilisateur.setValid(true);
	}

	public boolean existeLogin(Compte compte) {
		String login = compte.getLogin();
		Query query = em.createQuery("select c from Compte c where c.login=:login");
		query.setParameter("login", login);
		List<Compte> req = query.getResultList();
		if (req.isEmpty())
			return false;
		return true;
	}

	public Compte consulterCompte(int num) {
		Compte c = em.find(Compte.class, num);
		if (c == null)
			throw new RuntimeException("Compte introuvable");
		return c;
	}

	public Compte chercherCompte(Utilisateur utilisateur) {
		String login = utilisateur.getLogin();
		String password = utilisateur.getPassword();
		Query query = em.createQuery("select c from Compte c where c.login=:login and c.password=:password");
		query.setParameter("login", login);
		query.setParameter("password", password);
		Compte c = (Compte) query.getSingleResult();
		if (c == null)
			throw new RuntimeException("Compte introuvable");
		return c;
	}

	public Compte chercherCompte(String login) {
		Query query = em.createQuery("select c from Compte c where c.login=:login");
		query.setParameter("login", login);
		Compte c = (Compte) query.getSingleResult();
		if (c == null)
			throw new RuntimeException("Compte introuvable");
		return c;
	}

	public Categorie chercherCategorie(String nom) {
		Query query = em.createQuery("select c from Categorie c where c.nom=:nom");
		query.setParameter("nom", nom);
		Categorie c = (Categorie) query.getSingleResult();
		if (c == null)
			throw new RuntimeException("Catégorie introuvable");
		return c;
	}

	public void associer(int souscripteurId, int souscriptionId) {
		Compte souscripteur = em.find(Compte.class, souscripteurId);
		Compte souscription = em.find(Compte.class, souscriptionId);
		souscripteur.getSouscriptions().add(souscription);
	}


}
