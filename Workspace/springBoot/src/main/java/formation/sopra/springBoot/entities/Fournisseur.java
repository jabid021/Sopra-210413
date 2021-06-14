package formation.sopra.springBoot.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;

@Entity
@Table(name = "provider")
//@DiscriminatorValue("FR")
public class Fournisseur extends Personne {
	@OneToMany(mappedBy = "fournisseur", fetch = FetchType.LAZY)
	List<Produit> produits;
	// Set<Produit>
	@Column(name = "contact", length = 100)
	@Email
	// @EmailUnique
	private String contact;

	public Fournisseur() {

	}

	@Override
	public String getInfos() {
		return super.getInfos() + " " + contact;
	}

	public Fournisseur(String prenom, String nom, String contact) {
		super(prenom, nom);
		this.contact = contact;
	}

	public Fournisseur(String prenom, String nom) {
		super(prenom, nom);
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public List<Produit> getProduits() {
		return produits;
	}

	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

}
