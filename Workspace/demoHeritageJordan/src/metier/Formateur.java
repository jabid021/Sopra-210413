package metier;

public class Formateur extends Personne {

	
	protected String matiere;

	public Formateur(String nom, String prenom, int age, String matiere) {
		super(nom,prenom,age);
		this.matiere = matiere;
	}

	public String getMatiere() {
		return matiere;
	}

	public void setMatiere(String matiere) {
		this.matiere = matiere;
	}

	@Override
	public String toString() {
		return "Formateur [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", matiere=" + matiere + "]";
	}
	
	
	
	
	
	
}
