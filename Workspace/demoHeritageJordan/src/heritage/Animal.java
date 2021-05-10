package heritage;

public abstract class Animal {

	protected double poids;
	protected double taille;


	public Animal(double poids, double taille) {
		this.poids = poids;
		this.taille = taille;
	}


	public double getPoids() {
		return poids;
	}


	public void setPoids(double poids) {
		this.poids = poids;
	}


	public double getTaille() {
		return taille;
	}

	public void setTaille(double taille) {
		this.taille = taille;
	}

	
}
