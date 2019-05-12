package pack;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Salon {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;

	private String nom;
	private String lien;
	
	@OneToOne(fetch=FetchType.EAGER)
	private Categorie categorie;
	
	public Salon() {
	}
	
	public Salon(String nom, String lien, Categorie categorie) {
		this.nom = nom;
		this.lien = lien;
		this.categorie = categorie;
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

	public Categorie getCategorie() {
		return categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}
}
