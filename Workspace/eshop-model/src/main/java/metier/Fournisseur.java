package metier;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
//@DiscriminatorValue("supplier")
public class Fournisseur extends Personne{

	@Column(nullable=false)
	private String societe;
	
	
	@OneToMany(mappedBy = "fournisseur")
	private List<Produit> offres;
	
	
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

	public List<Produit> getOffres() {
		return offres;
	}

	public void setOffres(List<Produit> offres) {
		this.offres = offres;
	}

	@Override
	public String toString() {
		return "Fournisseur [societe=" + societe + ", id=" + id + ", prenom=" + prenom + ", nom=" + nom + "]";
	}
	
	
	
}
