package heritage;

public class Ours extends Animal implements Carnivore,Herbivore {

	
	
	protected String couleur;
	protected boolean gentil;
	
	public Ours(double poids, double taille,String couleur, boolean gentil) {
		super(poids, taille);
		this.couleur=couleur;
		this.gentil=gentil;
	}

	public String getCouleur() {
		return couleur;
	}

	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public boolean isGentil() {
		return gentil;
	}

	public void setGentil(boolean gentil) {
		this.gentil = gentil;
	
	}
	
	@Override
	public void manger(String plante) {
		System.out.println("Manger une "+plante);
		
	}

	@Override
	public void chasser(Animal a) {
		System.out.println("Cours "+a);
		
	}

	

	@Override
	public String toString() {
		return "Ours [couleur=" + couleur + ", gentil=" + gentil + ", poids=" + poids + ", taille=" + taille + "]";
	}

	@Override
	public void m1() {
		Carnivore.super.m1();
		Herbivore.super.m1();
	}

	
	
	
}
