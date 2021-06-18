package formation.sopra.springBoot.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.entities.views.Views;

@Entity
@Table(name = "ligne_commande")
public class LigneCommande {
	@EmbeddedId
	@JsonView(Views.CommandeWithLigneCommande.class)
	private LigneCommandeKey key;
	@JsonView(Views.Common.class)
	@Column(name = "quantite")
	private int quantite;

	public LigneCommande() {

	}

	public LigneCommande(LigneCommandeKey key, int quantite) {
		this.key = key;
		this.quantite = quantite;
	}

	public LigneCommandeKey getKey() {
		return key;
	}

	public void setKey(LigneCommandeKey key) {
		this.key = key;
	}

	public int getQuantite() {
		return quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((key == null) ? 0 : key.hashCode());
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
		LigneCommande other = (LigneCommande) obj;
		if (key == null) {
			if (other.key != null)
				return false;
		} else if (!key.equals(other.key))
			return false;
		return true;
	}

}
