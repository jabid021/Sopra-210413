package metier;

public class Girafe extends Animal implements Herbivore  {

	
	private int nbTaches;
	
	public Girafe(double poids, double taille,int nbTaches) {
		super(poids, taille);
		this.nbTaches=nbTaches;
	}

	public int getNbTaches() {
		return nbTaches;
	}

	public void setNbTaches(int nbTaches) {
		this.nbTaches = nbTaches;
	}

	
	@Override
	public String toString() {
		return "Girafe [nbTaches=" + nbTaches + ", poids=" + poids + ", taille=" + taille + "]";
	}

	@Override
	public void manger(String plante) {
		System.out.println("miam les "+plante);
	}
	
	
	
}
