package formation.sopra.springBoot.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.entities.views.Views;
import formation.sopra.springBoot.validations.MultipleDix;

@Entity
@Table(name = "produit")
@SequenceGenerator(name = "seqProduit", sequenceName = "seq_produit", initialValue = 100, allocationSize = 1)
public class Produit {
	@JsonView(Views.Common.class)
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqProduit")
	private Integer id;
	@JsonView(Views.Common.class)
	@Column(name = "nom", length = 100, nullable = false)
	@NotEmpty(message = "le nom ne peut pas etre vide")
	@Size(min = 2)
	private String nom;
	@JsonView(Views.Common.class)
	@Column(name = "prix")
	@Min(value = 1)
	@MultipleDix
	private double prix;
	// @JsonIgnore
	@JsonView(Views.ProduitWithFournisseur.class)
	@ManyToOne
	@JoinColumn(name = "id_fournisseur", foreignKey = @ForeignKey(name = "produit_id_fournisseur_fk"))
	private Fournisseur fournisseur;
	@JsonIgnore
	@OneToMany(mappedBy = "key.produit")
	private List<LigneCommande> lignesCommandes = new ArrayList<>();

	public Produit() {

	}

	public Produit(String nom, double prix) {
		this.nom = nom;
		this.prix = prix;
	}

	public Produit(String nom, double prix, Fournisseur fournisseur) {
		this.nom = nom;
		this.prix = prix;
		this.fournisseur = fournisseur;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public Fournisseur getFournisseur() {
		return fournisseur;
	}

	public void setFournisseur(Fournisseur fournisseur) {
		this.fournisseur = fournisseur;
	}

	public List<LigneCommande> getLignesCommandes() {
		return lignesCommandes;
	}

	public void setLignesCommandes(List<LigneCommande> lignesCommandes) {
		this.lignesCommandes = lignesCommandes;
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

	@Override
	public String toString() {
		return "Produit [id=" + id + ", nom=" + nom + ", prix=" + prix + "]";
	}

}
