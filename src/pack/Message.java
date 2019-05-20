package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Message {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	
	int id;
	String user;
	String text;
	String date;

	public Message(){
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