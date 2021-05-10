package metier;

public class Assistant  extends Formateur{

	private int motivation;
	
	
	
	public Assistant(String nom, String prenom, int age, int motivation,String matiere) {
		super(nom, prenom, age, matiere);
		this.motivation = motivation;
	}

	public int getMotivation() {
		return motivation;
	}



	public void setMotivation(int motivation) {
		this.motivation = motivation;
	}

	@Override
	public String toString() {
		return "Assistant [motivation=" + motivation + ", matiere=" + matiere + ", nom=" + nom + ", prenom=" + prenom
				+ ", age=" + age + "]";
	}



	
	
	
}
