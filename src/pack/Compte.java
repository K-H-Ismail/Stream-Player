package pack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Compte {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
	
	private String login;
	private String password;
	private String email;
	private String image = "profile-pic.png";

    @OneToMany(fetch=FetchType.EAGER)
    private List<Compte> souscriptions = new ArrayList<>();

	@OneToMany(mappedBy="proprietaire")
	private List<Fichier> fichiers;

	@OneToOne(mappedBy="streamer")
	private Salon salon;

	
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

	public List<Compte> getSouscriptions() {
		return this.souscriptions;
	}

	public void setSouscriptions(List<Compte> souscriptions) {
		this.souscriptions = souscriptions;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public List<Fichier> getFichiers() {
		return this.fichiers;
	}

	public void setFichiers(List<Fichier> fichiers) {
		this.fichiers = fichiers;
	}

	public Salon getSalon() {
		return salon;
	}

	public void setSalon(Salon salon) {
		this.salon = salon;
	}
}
