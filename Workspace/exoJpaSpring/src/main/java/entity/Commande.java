package entity;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "commande")
@SequenceGenerator(name = "seqCommande", sequenceName = "seq_commande", initialValue = 100, allocationSize = 1)
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seqCommande")
	private Integer numero;
	@Column(name = "date_commande")
	private LocalDate date;
	@ManyToOne
	@JoinColumn(name = "id_client", foreignKey = @ForeignKey(name = "commande_id_client_fk"), nullable = false)
	private Client client;
	@OneToMany(mappedBy = "key.commande")
	private List<LigneCommande> lignesCommandes;

	public Commande() {

	}

	public Commande(LocalDate date, Client client) {
		this.date = date;
		this.client = client;
	}

	public Commande(Client client) {
		this.client = client;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
		Commande other = (Commande) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

}
