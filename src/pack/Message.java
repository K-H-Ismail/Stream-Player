package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	int id;
	
	@ManyToOne
	private Chat chat;
	
	String user;
	String text;
	String date;

	public Message(){
	}
	
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	public Message(String user, String text, String date){
		this.user = user;
		this.text = text;
		this.date = date;
	}
	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}

	public String getUser() {
		return user;
	}


	public void setUser(String user) {
		this.user = user;
	}
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	
	
}