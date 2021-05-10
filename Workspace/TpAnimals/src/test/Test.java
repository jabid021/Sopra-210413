package test;

import java.util.ArrayList;
import java.util.List;

import metier.Animal;
import metier.Carnivore;
import metier.Elephant;
import metier.Girafe;
import metier.Herbivore;
import metier.Humain;
import metier.Lion;
import metier.Ours;
import metier.Tigre;

public class Test {

	public static void main(String[] args) {
		
		System.out.println(1/0);
		Lion simba = new Lion();
		Tigre tigrou = new Tigre();
		Elephant dumbo = new Elephant();
		Elephant babar = new Elephant();
		Girafe sophie = new Girafe();
		Ours balou =new Ours();
		Ours pô = new Ours();
		Ours martin = new Ours();
		Humain jordan =new Humain();
		
		
		List<Animal> zoo = new ArrayList();
		List<Carnivore> carnivores = new ArrayList();
		List<Herbivore> herbivores = new ArrayList();
		
		zoo.add(simba);
		zoo.add(tigrou);
		zoo.add(dumbo);
		zoo.add(babar);
		zoo.add(sophie);
		zoo.add(balou);
		zoo.add(pô);
		zoo.add(martin);
		
		carnivores.add(jordan);
		herbivores.add(jordan);
		
		simba.manger(babar);
		pô.manger(tigrou);
		martin.manger("plantes");
		
		
		for(Animal a : zoo) {
			if(a instanceof Carnivore && a instanceof Herbivore) 
			{
				System.out.println(a.getClass().getSimpleName()+" est omnivore");
				carnivores.add((Carnivore) a);
				herbivores.add((Herbivore) a);
			}
			else if(a instanceof Carnivore ) 
			{
				System.out.println(a.getClass().getSimpleName()+" est carnivore");
				carnivores.add((Carnivore) a);
			}
			else 
			{
				herbivores.add((Herbivore) a);
				System.out.println(a.getClass().getSimpleName()+" est herbivore");
			}

		}
		

	}

}
