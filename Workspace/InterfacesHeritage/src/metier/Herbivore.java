package metier;

public interface Herbivore {

	public void manger(String plante);
	public default void m1() {System.out.println("Je suis m1 de Herbi");}
	
}
