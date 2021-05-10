package metier;

public enum Carte {
	CB(0),Visa(5),MC(10);
	private double prix;
	
	private Carte(double prix) 
	{
		this.prix=prix;
	}
	
	
	public double getPrix() {
		return prix;
	}

}
