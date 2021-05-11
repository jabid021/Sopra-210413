package metier;

import java.io.Serializable;

public class Patient implements Serializable {

	
	private int id;
	private String nom,prenom,tel;
	private Adresse adresse;
	
	
	public Patient(int secu, String nom, String prenom) {
		this.id = secu;
		this.nom = nom;
		this.prenom = prenom;
	}


	public Patient(int secu, String nom, String prenom, String tel, Adresse adresse) {
		this.id = secu;
		this.nom = nom;
		this.prenom = prenom;
		this.tel = tel;
		this.adresse = adresse;
	}


	public int getId() {
		return id;
	}


	public void setId(int secu) {
		this.id = secu;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
	}


	public Adresse getAdresse() {
		return adresse;
	}


	public void setAdresse(Adresse adresse) {
		this.adresse = adresse;
	}


	@Override
	public String toString() {
		return "Patient [secu=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse
				+ "]";
	}
	
	
	
	
	
	
	
}
