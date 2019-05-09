package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Utilisateur {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;

	private String login;
	private String password;
	private boolean valid;

	public Utilisateur() {
	}
	
	public Utilisateur(String login) {
		this.login = login;
	}

	public Utilisateur(String login, String password) {
		this.login = login;
		this.password = password;
	}
	

	public int getId() {
		return this.num;
	}

	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isValid() {
		return valid;
	}

	public void setValid(boolean valid) {
		this.valid = valid;
	}

}
