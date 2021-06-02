package eshop.metier;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Embeddable
public class AchatPK implements Serializable{
	@ManyToOne
	@JoinColumn(name="id_produit",foreignKey = @ForeignKey(name="achat_id_produit_fk"))
	private Produit produit;
	@ManyToOne
	@JoinColumn(name="id_client",foreignKey = @ForeignKey(name="achat_id_client_fk"))
	private Client client;
	
	public AchatPK() {
		
	}

	public AchatPK(Produit produit, Client client) {
		super();
		this.produit = produit;
		this.client = client;
	}

	public Produit getProduit() {
		return produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((client == null) ? 0 : client.hashCode());
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
		AchatPK other = (AchatPK) obj;
		if (client == null) {
			if (other.client != null)
				return false;
		} else if (!client.equals(other.client))
			return false;
		if (produit == null) {
			if (other.produit != null)
				return false;
		} else if (!produit.equals(other.produit))
			return false;
		return true;
	}
	
	
	
	
}
