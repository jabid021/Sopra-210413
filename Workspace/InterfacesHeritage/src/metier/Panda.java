package metier;

public class Panda extends Ours {
	
	private int bambou;
	

	public Panda(double poids, double taille, String couleur, boolean gentil, int bambou) {
		super(poids, taille, couleur, gentil);
		this.bambou = bambou;
	}	

	public int getBambou() {
		return bambou;
	}

	public void setBambou(int bambou) {
		this.bambou = bambou;
	}


	@Override
	public String toString() {
		return "Panda [bambou=" + bambou + ", couleur=" + couleur + ", gentil=" + gentil + ", poids=" + poids
				+ ", taille=" + taille + "]";
	}
	
	
}
