package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;

	private String login;
	private String password;
	private String email;
	private Boolean estValide;

	public Compte() {
	}

	public Compte(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public Compte(String login, String password, String email) {
		this.login = login;
		this.password = password;
		this.email = email;
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

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public boolean estValide() {
		return estValide;
	}

	public void setValid(boolean newValid) {
		this.estValide = newValid;
	}

}
