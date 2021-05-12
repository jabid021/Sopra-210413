package metier;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Bureau {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	private double superficie;
	
	@OneToOne(mappedBy = "bureau")
	private Medecin medecin;
	
	public Bureau() {
	}

	public Bureau(double superficie) {
		this.superficie = superficie;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}
	
	
	
	
}
