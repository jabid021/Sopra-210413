package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class LigneCommandeKey implements Serializable{
    @ManyToOne
    @JoinColumn(name = "lc_produit_id",foreignKey=@ForeignKey(name="ligne_commande_produit_id_fk"))
    private Produit produit;
    @ManyToOne
    @JoinColumn(name = "lc_commande_id",foreignKey=@ForeignKey(name="ligne_commande_commande_id_fk"))
    private Commande commande;

    public LigneCommandeKey() {

    }

    public LigneCommandeKey(Produit produit, Commande commande) {
	this.produit = produit;
	this.commande = commande;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((commande == null) ? 0 : commande.hashCode());
	result = prime * result + ((produit == null) ? 0 : produit.hashCode());
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
	LigneCommandeKey other = (LigneCommandeKey) obj;
	if (commande == null) {
	    if (other.commande != null)
		return false;
	} else if (!commande.equals(other.commande))
	    return false;
	if (produit == null) {
	    if (other.produit != null)
		return false;
	} else if (!produit.equals(other.produit))
	    return false;
	return true;
    }
    
    

}
