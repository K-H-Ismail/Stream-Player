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
	
	public void ajoutCompte(String login, String password, String email) {
		Compte c = new Compte(login,password,email);
		em.persist(c);
	}
	
	public Collection<Compte> listeCompte() {
		TypedQuery<Compte> req = em.createQuery("select c from Compte c", Compte.class);
		return req.getResultList();
	}
	
	public Compte chercherCompte(String login, String password) {
		Query query = em.createQuery("select c from Compte c where c.login = :login and c.password = :password");
		query.setParameter("login", login);
		query.setParameter("password", password);		
		List<Compte> req = (List<Compte>) query.getResultList();
		if (req.isEmpty()) return null;
		return req.get(0);
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
	
