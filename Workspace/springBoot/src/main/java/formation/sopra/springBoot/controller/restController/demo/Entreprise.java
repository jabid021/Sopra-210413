package formation.sopra.springBoot.controller.restController.demo;

public class Entreprise {
	private String nom;
	private long capital;
	private Responsable responsable;

	public Entreprise() {

	}

	public Entreprise(String nom, long capital) {
		super();
		this.nom = nom;
		this.capital = capital;
	}

	public Entreprise(String nom, long capital, Responsable responsable) {
		super();
		this.nom = nom;
		this.capital = capital;
		this.responsable = responsable;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public long getCapital() {
		return capital;
	}

	public void setCapital(long capital) {
		this.capital = capital;
	}

	public Responsable getResponsable() {
		return responsable;
	}

	public void setResponsable(Responsable responsable) {
		this.responsable = responsable;
	}
	

}
