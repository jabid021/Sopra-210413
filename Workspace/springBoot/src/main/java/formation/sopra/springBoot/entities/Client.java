package formation.sopra.springBoot.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
//@DiscriminatorValue("CL")
public class Client extends Personne {
	@OneToMany(mappedBy = "client")
	private List<Commande> commandes;
	@OneToOne
	@JoinColumn(name = "user_id")
	private Utilisateur utilisateur;

	public Client() {

	}

	public Client(String prenom, String nom, String commentaire) {
		super(prenom, nom, commentaire);
	}

	public Client(String prenom, String nom) {
		super(prenom, nom);
	}

	public List<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(List<Commande> commandes) {
		this.commandes = commandes;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

}
