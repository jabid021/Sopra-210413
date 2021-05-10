package metier;

public class Voiture {

	
	private int vitesse=0;
	private boolean enMarche=false;
	
	
	public void demarrer(int vitesse) 
	{
		this.vitesse=vitesse;
		enMarche=true;
	}
}
