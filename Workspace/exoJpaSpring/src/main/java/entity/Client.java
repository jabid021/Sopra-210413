package entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
//@DiscriminatorValue("CL")
public class Client extends Personne {
    @OneToMany(mappedBy = "client")
    private List<Commande> commandes;

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

}
