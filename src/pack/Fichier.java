package pack;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Fichier {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int num;
    private String description;
    private String nom;
    
    @ManyToOne
    private Compte proprietaire;

    public Fichier() {
    }
    
	public int getNum() {
		return this.num;
	}
    
    public String getDescription() {
        return description;
    }

    public void setDescription( String description ) {
        this.description = description;
    }

    public String getNom() {
        return nom;
    }

    public void setNom( String nom ) {
        this.nom = nom;
    }

	public Compte getProprietaire() {
		return proprietaire;
	}

	public void setProprietaire(Compte proprietaire) {
		this.proprietaire = proprietaire;
	}
}