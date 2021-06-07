package exoServlet.model;

public class Client {
	private String prenom;
	private String nom;
	private Civilite civilite;

	public Client() {

	}

	public Client(String prenom, String nom, Civilite civilite) {
		super();
		this.prenom = prenom;
		this.nom = nom;
		this.civilite = civilite;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Civilite getCivilite() {
		return civilite;
	}

	public void setCivilite(Civilite civilite) {
		this.civilite = civilite;
	}

	public String getInfos() {
		return civilite.getTitre() + " " + prenom + " " + nom;
	}
}
