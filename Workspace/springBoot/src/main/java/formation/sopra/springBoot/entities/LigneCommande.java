package formation.sopra.springBoot.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "ligne_commande")
public class LigneCommande {
    @EmbeddedId
    private LigneCommandeKey key;
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
