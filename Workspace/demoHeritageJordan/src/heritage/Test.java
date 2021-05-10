package heritage;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void exemplesCast() 
	{
		double x = 12.15;
		System.out.println((int) x); // => 12
		int i = 65; //A
		System.out.println((char) i); // => A
		
		char lettre='B';
		System.out.println((int) lettre); // => 66
	}
	
	public static void main(String[] args) {
		
		List<Animal> zoo = new ArrayList();
		List<Carnivore> carnivores = new ArrayList();
		
		Girafe sophie = new Girafe(600, 5.75, 600);
		Ours bepo = new Ours(400,2.4,"Blanc",true);
		
		Panda pô = new Panda(400,2,"Blanc-gris",true,1000);
		
		Grizzli scarface= new Grizzli(650, 3.2, "Brun", false);
		
		Dragon mushu = new Dragon(6,0.7);
		
		/*mushu.manger(bepo);
		pô.manger("bambou");
		pô.manger(mushu);*/
		
		
		zoo.add(sophie);
		zoo.add(bepo);
		zoo.add(pô);
		zoo.add(scarface);
		zoo.add(mushu);
		carnivores.add(mushu);
		carnivores.add(pô);
		
		for(Animal a : zoo) 
		{
			if(a instanceof Carnivore && a instanceof Herbivore) 
			{
				System.out.println(a.getClass().getSimpleName()+" est omnivore");
				((Carnivore)a).manger(mushu);
				((Herbivore)a).manger("plante");
				System.out.println("\n");
			}
			else if(a instanceof Carnivore) 
			{
				System.out.println(a.getClass().getSimpleName()+" est carnivore");
				((Carnivore)a).manger(mushu);
				System.out.println("\n");
			}
			else 
			{
				System.out.println(a.getClass().getSimpleName()+" est herbivore");
				((Herbivore)a).manger("plante");
				System.out.println("\n");
			}
		}
		
		
		
	}

}
