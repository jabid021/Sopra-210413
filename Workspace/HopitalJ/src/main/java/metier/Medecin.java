package metier;

import java.util.ArrayList;
import java.util.List;

public class Medecin extends Compte {

	private int salle;
	private List<Visite> visites=new ArrayList();

	public Medecin() {
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

	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", visites=" + visites + ", id=" + id + ", login=" + login + ", password="
				+ password + "]";
	}

	
	
	
	
	
}
