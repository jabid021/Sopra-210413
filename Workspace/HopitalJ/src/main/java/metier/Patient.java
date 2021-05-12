package metier;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

//Obligatoire
@Entity
public class Patient implements Serializable {

	//Obligatoire
	@Id
	
	//Opt
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nom,prenom,tel;
	
	@Embedded
	private Adresse adresse;
	
	@ManyToMany
	@JoinTable(
			name="maladies",
			joinColumns = @JoinColumn(name="idPatient"),
			inverseJoinColumns = @JoinColumn(name="idSymptome")
			)
	private List<Symptome> maladies;
	
	
	//Obligatoire
	public Patient() {
		
	} 
	
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


	
	public List<Symptome> getMaladies() {
		return maladies;
	}

	public void setMaladies(List<Symptome> maladies) {
		this.maladies = maladies;
	}

	@Override
	public String toString() {
		return "Patient [secu=" + id + ", nom=" + nom + ", prenom=" + prenom + ", tel=" + tel + ", adresse=" + adresse
				+ "]";
	}
	
	
	
	
	
	
	
}
