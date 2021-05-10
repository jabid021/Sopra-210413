package metier;

public class Eleve extends Personne{

	


	private double note;
	
	public Eleve(String nom, String prenom, int age, double note) {
		super(nom,prenom,age);
		this.note = note;
	}
	
	
	
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}


	@Override
	public String toString() {
		return "Eleve [nom=" + nom + ", prenom=" + prenom + ", age=" + age + ", note=" + note + "]";
	}
	
	
	
	
	
	
}
