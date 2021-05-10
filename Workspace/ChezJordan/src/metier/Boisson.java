package metier;

public enum Boisson {

	
	eau(1),coca(2.5),fanta(2.5);
	
	private double prix;
	
	private Boisson(double prix) 
	{
		this.prix=prix;
	}
	
	public double getPrix() {return prix;}
	
}
