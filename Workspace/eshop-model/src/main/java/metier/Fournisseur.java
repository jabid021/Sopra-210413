package metier;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
//@DiscriminatorValue("supplier")
public class Fournisseur extends Personne{

	@Column(nullable=false)
	private String societe;
	
	public Fournisseur() {
	}

	public Fournisseur(String prenom,String nom,String societe) {
		super(prenom,nom);
		this.societe = societe;
	}

	public String getSociete() {
		return societe;
	}

	public void setSociete(String societe) {
		this.societe = societe;
	}
	
}
