package heritage;

public class Grizzli extends Ours{
	
	
	

	public Grizzli(double poids, double taille, String couleur, boolean gentil) {
		super(poids, taille, couleur, gentil);
	}

	@Override
	public String toString() {
		return "Grizzli [couleur=" + couleur + ", gentil=" + gentil + ", poids=" + poids + ", taille=" + taille + "]";
	}

	
	
}
