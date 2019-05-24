package pack;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Salon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;

	private String nom;
	private String lien;
	
	@ManyToMany
	private List<Categorie> categories;
	
	@OneToOne
	private Compte streamer;
	
	
	public Salon() {
	}
	
	public Salon(String nom, String lien, List<Categorie> categories) {
		this.nom = nom;
		this.lien = lien;
		this.categories = categories;
	}
	
	public int getNum() {
		return this.num;
	}
	
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getLien() {
		return lien;
	}
	public void setLien(String lien) {
		this.lien = lien;
	}

	public List<Categorie> getCategories() {
		return categories;
	}

	public void setCategories(List<Categorie> categories) {
		this.categories = categories;
	}
	
	public Compte getStreamer() {
		return streamer;
	}
	public void setStreamer(Compte streamer) {
		this.streamer = streamer;
	}

}
