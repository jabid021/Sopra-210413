package metier;

import java.io.Serializable;

public class Departement implements Serializable{
	private int id;
	private String nom;
	private String ville;
	
	public Departement() {}
	
	public Departement(int id, String nom, String ville) {
		this.id = id;
		this.nom = nom;
		this.ville = ville;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", ville=" + ville + "]";
	}
	
	
	
	
	
}
