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
	
	public Collection<Compte> listeCompte() {
		TypedQuery<Compte> req = em.createQuery("select c from Compte c", Compte.class);
		return req.getResultList();
	}
	
	public void verifierCompte(Utilisateur utilisateur) {
		String login = utilisateur.getLogin();
		String password = utilisateur.getPassword();
		Query query = em.createQuery("select c from Compte c where c.login=:login and c.password=:password");
		query.setParameter("login", login);
		query.setParameter("password", password);		
		List<Compte> req = (List<Compte>) query.getResultList();
		if (req.isEmpty()) utilisateur.setValid(false);
		else utilisateur.setValid(true);
	}
	
	public boolean existe(Compte compte) {
		return em.contains(compte);
	}

	public Compte consulterCompte(int num) {
		Compte c = em.find(Compte.class, num);
		if (c == null) throw new RuntimeException("Compte introuvable");
		return c;
	}
	
}
	
