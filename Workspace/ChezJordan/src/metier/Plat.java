package metier;

public enum Plat {

	kebab(2.5),tacos(2.7),pizza(9.5),soupe(4);
	
	private double prix;
	
	private Plat(double prix) 
	{
		this.prix=prix;
	}
	
	public double getPrix() {return prix;}
	

	
	
	
}
