package metier;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Symptome {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	private String nom;
	
	@ManyToMany(mappedBy = "maladies")
	private List<Patient> malades;
	
	public Symptome() {
	}

	public Symptome(int id, String nom) {
		this.id = id;
		this.nom = nom;
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

	public List<Patient> getMalades() {
		return malades;
	}

	public void setMalades(List<Patient> malades) {
		this.malades = malades;
	}

	@Override
	public String toString() {
		return "Symptome [id=" + id + ", nom=" + nom + "]";
	}
	
	
	
}
