package metier;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
public class Visite {

	@Id
	@GeneratedValue(strategy =GenerationType.IDENTITY )
	private int id;
	
	@ManyToOne
	@JoinColumn(name="idPatient")
	private Patient patient;
	@ManyToOne
	@JoinColumn(name="idMedecin")
	private Medecin medecin;
	
	
	private double prix=20;
	private LocalDate date;
	private int salle;
	
	
	public Visite() {
	}
	
	public Visite(int id, Patient patient, Medecin medecin, double prix, String date, int salle) {
		this.id = id;
		this.patient = patient;
		this.medecin = medecin;
		this.prix = prix;
		this.date = LocalDate.parse(date);
		this.salle = salle;
	}
	
	public Visite(Patient patient, Medecin medecin) {
		this.patient = patient;
		this.medecin = medecin;
		this.date = LocalDate.now();
		this.salle = medecin.getSalle();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	public Medecin getMedecin() {
		return medecin;
	}

	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}

	@Override
	public String toString() {
		return "Visite [id=" + id + ", prix=" + prix + ", date=" + date + ", salle=" + salle + "]";
	}

	
	
	
}
