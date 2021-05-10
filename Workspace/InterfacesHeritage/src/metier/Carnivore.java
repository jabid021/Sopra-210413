package metier;

public interface Carnivore {
	
	public void chasser(Animal a);
	
	public default void manger(Animal a) {
		System.out.println("Je devore un "+a.getClass().getSimpleName());
	}
	
	public default void m1() {System.out.println("Je suis m1 de Carni");}
}
