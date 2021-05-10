package heritage;

public class Dragon extends Animal implements Carnivore{

	public Dragon(double poids, double taille) {
		super(poids, taille);
	}

	@Override
	public void chasser(Animal a) {
		System.out.println("Cours "+a);
		
	}

	
}
