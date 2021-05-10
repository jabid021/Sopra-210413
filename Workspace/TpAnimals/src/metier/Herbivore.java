package metier;

public interface Herbivore {

	
	public default void manger(String plante) 
	{
		System.out.println(this.getClass().getSimpleName()+" mange "+plante);
	}
}
