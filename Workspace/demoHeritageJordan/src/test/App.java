package test;

import java.util.ArrayList;
import java.util.List;

import metier.Assistant;
import metier.Eleve;
import metier.Formateur;
import metier.Personne;

public class App {

	
	public static void maFunction(String msg) 
	{
		System.out.println(msg);
	}
	
	
	public static void maFunction(String msg,int age) 
	{
		System.out.println("Autre chose");
	}
	
	public static void maFunction(int age,String msg) 
	{
		System.out.println("Autre chose");
	}
	
	public static void maFunction(String nom,String prenom) 
	{
		System.out.println("Autre chose");
	}
	

	public static void main(String[] args) {
		
		
		maFunction("toto","titi");
		

		maFunction(12,"toto");
		
		
		//Eleve+Personne
		Eleve e = new Eleve("Doe", "John", 42, 18.5);
		Eleve e2 = new Eleve("Doe", "Jane", 42, 20);

		//Formateur+Personne
		Formateur f = new Formateur("Abid","Jordan",27,"Java");

		//Assistant+Formateur+Personne
		Assistant a = new Assistant("D","Ewan",24,8,"Java");



		List<Personne> salle = new ArrayList();
		salle.add(e);
		salle.add(e2);
		salle.add(f);
		salle.add(a);


		System.out.println(salle);
	}

}
