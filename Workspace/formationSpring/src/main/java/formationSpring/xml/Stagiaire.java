package formationSpring.xml;

public class Stagiaire {

	private String prenom;
	private Formation formation;

	public Stagiaire() {
	}

	public void methodeStagiaire() {
		System.out.println("methode stagiaire");
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

}
