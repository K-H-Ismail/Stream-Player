package pack;

import java.util.Collection;
import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

@Singleton
public class FacadeChat {
	
	@PersistenceContext
	private EntityManager em;
	
	public void ajoutChat(Chat chat){
		em.persist(chat);
	}
	
	public void ajoutMessage(Message m,int idChat) {
		Chat chat = em.find(Chat.class, idChat);
		m.setChat(chat);
		em.persist(m);
	}
	
	public Collection<Message> messages(int idChat) {
		Chat chat = em.find(Chat.class, idChat);
		return chat.getMessages();
	}
	
	public Collection<Message> messagesInd(int indDernier,int idChat) {
		Chat chat = em.find(Chat.class, idChat);
		Collection<Message> msgs =chat.getMessages();					
		int len = msgs.size();
		return ((List<Message>) msgs).subList(indDernier, len);
	}	
	
	public Collection<Chat> chats(){
		TypedQuery<Chat> req = em.createQuery("select c from Chat c", Chat.class);
		return req.getResultList();
		
	}
}
	
