package eshop.metier;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", allocationSize = 1, initialValue = 100)
public class Produit {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	private Long id;
	private String libelle;
	private double prix;

	@ManyToOne(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinColumn(name = "id_fournisseur", foreignKey = @ForeignKey(name = "produit_id_fournisseur_fk"))
	private Fournisseur fournisseur;
	@OneToMany(mappedBy = "id.produit")
	List<Achat> achats;

	public Produit() {
	}

	public Produit(String libelle, double prix, Fournisseur fournisseur) {
		this.libelle = libelle;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle.toLowerCase();
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		if (prix < 0) {
			this.prix = 1;
		}
		this.prix = prix;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	@Override
	public String toString() {
		return "Produit [id=" + id + ", libelle=" + libelle + ", prix=" + prix + ", fournisseur=" + fournisseur + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
