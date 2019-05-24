package pack;

import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

@Singleton
public class FacadeChat {
	
	@PersistenceContext
	private EntityManager em;
	
	public void ajoutMessage(Message m) {
		em.persist(m);
	}
	
	public Collection<Message> messages() {
		TypedQuery<Message> req = em.createQuery("select m from Message m", Message.class);
		return req.getResultList();
	}
	
	public Collection<Message> messagesInd(int indDernier) {
		TypedQuery<Message> req = em.createQuery("select m from Message m", Message.class);
		int len = req.getResultList().size();
		return req.getResultList().subList(indDernier, len);
	}	
}
	
