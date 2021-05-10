package test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import metier.Boisson;
import metier.Client;
import metier.Plat;

public class Test {

	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static void main(String[] args) {


		Boisson[] carteBoissons = Boisson.values();
		Plat[] cartePlats= Plat.values();
		List<Boisson> boissonsClient = new ArrayList();
		List<Plat> platsClient = new ArrayList();
		double total=0;


		String nom = saisieString("Nom du client : ");

		Client c = new Client(nom,platsClient,boissonsClient);



		String question =saisieString("Voulez vous une boisson ? (y/n)");

		while(question.equals("y")) 
		{
			for(Boisson b : carteBoissons) 
			{
				System.out.println(b+" - "+b.getPrix()+"€");
			}
			String choixBoisson = saisieString("Quelle boisson ?");
			Boisson boisson = Boisson.valueOf(choixBoisson);
			boissonsClient.add(boisson);

			question =saisieString("Voulez vous une autre boisson ? (y/n)");
		}



		question =saisieString("Voulez vous un plat ? (y/n)");

		while(question.equals("y")) 
		{
			for(Plat p : cartePlats) 
			{
				System.out.println(p+" - "+p.getPrix()+"€");
			}
			String choixPlat = saisieString("Quel plat ?");
			Plat plat = Plat.valueOf(choixPlat);
			platsClient.add(plat);

			question =saisieString("Voulez vous un autre plat ? (y/n)");
		}




		if(boissonsClient.isEmpty() && platsClient.isEmpty()) 
		{
			System.out.println("Pas de commande pour ce client");
		}
		else 
		{
			System.out.println("Detail de la commande");
			for(Boisson b : boissonsClient) 
			{
				total+=b.getPrix();
				System.out.println(b);
			}

			for(Plat p : platsClient) 
			{
				total+=p.getPrix();
				System.out.println(p);
			}

			System.out.println("Total TTC pour le client : "+c.getNom()+"\t "+total+"€");
		}

	}
}
