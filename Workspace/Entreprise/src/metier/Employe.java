package metier;

import java.time.LocalDate;

public class Employe extends Compte{

	 private String nom;
	 private String poste;
	 private double salaire;
	 private Double comm;
	 private Employe manager;
	 private LocalDate embauche;
	 private Departement departement;
	
	 
	 public Employe() {}
	 
	 public Employe(int id, String login, String password, String nom, String poste, double salaire, Double comm,
			Employe manager, Departement departement,String embauche) {
		super(id, login, password);
		this.nom = nom;
		this.poste = poste;
		this.salaire = salaire;
		this.comm = comm;
		this.manager = manager;
		this.departement = departement;
		this.embauche=LocalDate.parse(embauche);
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPoste() {
		return poste;
	}
	public void setPoste(String poste) {
		this.poste = poste;
	}
	public double getSalaire() {
		return salaire;
	}
	public void setSalaire(double salaire) {
		this.salaire = salaire;
	}
	public Double getComm() {
		return comm;
	}
	public void setComm(Double comm) {
		this.comm = comm;
	}
	public Employe getManager() {
		return manager;
	}
	public void setManager(Employe manager) {
		this.manager = manager;
	}
	public Departement getDepartement() {
		return departement;
	}
	public void setDepartement(Departement departement) {
		this.departement = departement;
	}
	
	
	public LocalDate getEmbauche() {
		return embauche;
	}

	public void setEmbauche(String embauche) {
		this.embauche = LocalDate.parse(embauche);
	}

	@Override
	public String toString() {
		return "Employe [nom=" + nom + ", poste=" + poste + ", salaire=" + salaire + ", comm=" + comm + ", manager="
				+ manager + ", embauche=" + embauche + ", departement=" + departement + ", id=" + id + ", login="
				+ login + ", password=" + password + "]";
	}

	
	 
	 
	 
}
