package metier;

public class Personne {

	private String nom;
	private String prenom;
	private int age;
	private String adresse;
	
	

	public Personne(String nom,String prenom,String adresse) {
		this.nom = nom;
		this.prenom=prenom;
		this.adresse=adresse;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	
	
	
	
}
