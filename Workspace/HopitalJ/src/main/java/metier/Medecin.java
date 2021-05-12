package metier;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
//@DiscriminatorValue("medecin")
public class Medecin extends Compte {

	//Une col transient n'est pas ajoutée en base 
	private transient int salle;
	
	
	@OneToMany(mappedBy = "medecin")
	private List<Visite> visites=new ArrayList();
	
	@OneToOne
	@JoinColumn(name="id_du_bureau")
	private Bureau bureau;

	public Medecin() {
	}

	public Medecin(int id, String login, String password,Bureau bureau) {
		super(id, login, password);
		this.bureau=bureau;
	}
	
	public Medecin(int id, String login, String password) {
		super(id, login, password);
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}
	
	

	public List<Visite> getVisites() {
		return visites;
	}

	public void setVisites(List<Visite> visites) {
		this.visites = visites;
	}

	public Bureau getBureau() {
		return bureau;
	}

	public void setBureau(Bureau bureau) {
		this.bureau = bureau;
	}

	@Override
	public String toString() {
		return "Medecin [visites=" + visites + ", bureau=" + bureau + "]";
	}

	
	
	
	
	
	
}
