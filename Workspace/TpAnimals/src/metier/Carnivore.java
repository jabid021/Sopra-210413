package metier;

public interface Carnivore {

	
	public default void manger(Animal a) 
	{
		System.out.println(this.getClass().getSimpleName()+" mange "+a.getClass().getSimpleName());
	}
}
