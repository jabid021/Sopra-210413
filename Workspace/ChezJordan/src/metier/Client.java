package metier;

import java.util.List;

public class Client {

	
	private String nom;
	private List<Plat> plats;
	private List<Boisson> boissons;
	
	
	public Client(String nom, List<Plat> plats, List<Boisson> boissons) {
		this.nom = nom;
		this.plats = plats;
		this.boissons = boissons;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public List<Plat> getPlats() {
		return plats;
	}


	public void setPlats(List<Plat> plats) {
		this.plats = plats;
	}


	public List<Boisson> getBoissons() {
		return boissons;
	}


	public void setBoissons(List<Boisson> boissons) {
		this.boissons = boissons;
	}


	@Override
	public String toString() {
		return "Client [nom=" + nom + ", plats=" + plats + ", boissons=" + boissons + "]";
	}
	
	
	

}
