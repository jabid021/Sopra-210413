package formation.sopra.springBoot.controller.restController.demo;

public class Responsable {
	private String nom;

	public Responsable() {

	}

	public Responsable(String nom) {
		super();
		this.nom = nom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
