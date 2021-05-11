package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream.GetField;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import metier.Adresse;
import metier.Compte;
import metier.Medecin;
import metier.Patient;
import metier.Secretaire;
import metier.Visite;
import util.Context;

public class App {

	
	public static String saisieString(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc=new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static void accueil() {
		System.out.println("Welcome in Hospital\n");
		System.out.println("1 - Se connecter");
		System.out.println("2- Quitter");
		int choix=saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : connect();break;
		case 2 : System.out.println("L'appli va se fermer");System.exit(0);break;
		}	
		accueil();
	}

	public static void connect() {
		String login=saisieString("Saisir votre login");
		String password=saisieString("Saisir votre password");

		Compte connected=Context.get_instance().getDaoC().checkConnect(login, password);
		
		Context.get_instance().setConnected(connected);
		
		if(connected==null) {System.out.println("Identifiants invalides");accueil();}
		else {
			if(connected instanceof Medecin){((Medecin) connected).setSalle(saisieInt("choisir votre salle (1 ou 2)")); menuMedecin();}
			else if(connected instanceof Secretaire){menuSecretaire();}
			else {System.out.println("Error type de compte");}
		}
	}

	public static void menuSecretaire() {
		System.out.println("Menu Secretaire \n");
		boolean pause=Context.get_instance().isPause();
		
		if(!pause) 
		{
			System.out.println("1 - Ajouter un patient");
			System.out.println("2 - Afficher la file d'attente");
			System.out.println("3 - Partir en pause");
			System.out.println("4 - Afficher les visites d'un patient");
			System.out.println("5 - Se deconnecter");
		}
		else 
		{
			System.out.println("1 - Revenir de pause");
			System.out.println("2 - Se deconnecter");
		}

		int choix=saisieInt("Choisir un menu");
		if(pause) 
		{
			switch(choix)
			{
			case 1 : revenirPause();break;
			case 2 : accueil();break;
			}
		}
		else {
			switch(choix) 
			{
			case 1 : addPatient();break;
			case 2 : showPatients();break;
			case 3 : pause();break;
			case 4 : afficheVisites();break;
			case 5 : accueil();break;
			}	
		}
		menuSecretaire();
	}

	public static void afficheVisites() {
		int secu=saisieInt("Saisir votre numéro de secu");
		showVisite(secu);
		menuSecretaire();
	}

	public static void addPatient() {
		int secu=saisieInt("Saisir votre numéro de secu");

		Patient p = Context.get_instance().getDaoP().findById(secu);

		if(p==null) 
		{
			String prenom = saisieString("Saisir votre prenom *");
			String nom = saisieString("Saisir votre nom *");

			String tel = saisieString("Saisir votre tel");

			int numero=saisieInt("Saisir votre numero");
			String voie = saisieString("Saisir votre voie");
			String cp = saisieString("Saisir votre cp");
			String ville = saisieString("Saisir votre ville");

			p=new Patient(secu,nom,prenom,tel,new Adresse(numero,voie,cp,ville));	 
			Context.get_instance().getDaoP().insert(p);
		}
		Context.get_instance().getFileAttente().add(p);
	}

	public static void menuMedecin() {

		System.out.println("Menu Medecin \n");
		System.out.println("1 - Recevoir un patient");
		System.out.println("2 - Afficher la file d'attente");
		System.out.println("3 - Sauvegarder mes visites");
		System.out.println("4 - Se deconnecter");
		int choix=saisieInt("Choisir un menu");

		switch(choix) 
		{
		case 1 : recevoir();break;
		case 2 : showPatients();break;
		case 3 : saveVisites();break;
		case 4 : saveVisites();accueil();break;
		}	
		menuMedecin();
	}

	private static void showPatients() {
		if(Context.get_instance().getFileAttente().isEmpty()) {System.out.println("Aucun patient dans l'hopital");}
		Context.get_instance().getFileAttente().forEach(patient -> {System.out.println(patient);});
		//for(Patient patient : Hopital.get_instance().getFileAttente()) {System.out.println(patient);}
	}

	public static void recevoir()
	{
		if(!Context.get_instance().getFileAttente().isEmpty()) 
		{
			Patient p=Context.get_instance().getFileAttente().poll();
			Patient lastPatient= Context.get_instance().getLastPatient();
			Compte connected=Context.get_instance().getConnected();
			
			if(lastPatient!=null) 
			{
				System.out.println("Fin du rdv pour : "+lastPatient);
			}
			System.out.println("Debut du rdv pour : "+p);
			lastPatient=p;


			Visite v = new Visite(p,(Medecin) connected);
			List<Visite> visites = ((Medecin) connected).getVisites();
			visites.add(v);
			if(visites.size()==10) 
			{
				saveVisites();
			}
		}
		else {System.out.println("Aucun patient dans l'hopital");}

	}

	public static void saveVisites() 
	{
		List<Visite> visites = ((Medecin) Context.get_instance().getConnected()).getVisites();
		if(visites.isEmpty()) 
		{
			System.out.println("Pas de visite a sauvegarder");
		}
		else {

			for(Visite v : visites) 
			{
				Context.get_instance().getDaoV().insert(v);
			}

			System.out.println("La liste est save");	
			visites.clear();
		}
	}


	public static void pause() 
	{
		File file = new File("fileattente.txt");
		try {
			FileOutputStream fos = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(Context.get_instance().getFileAttente());
			oos.close();
			fos.close();
			Context.get_instance().getFileAttente().clear();
			Context.get_instance().setPause(true);
			System.out.println("La secretaire part en pause, la file d'attente est vide !");
		}catch(Exception e) 
		{System.out.println("La liste n'a pas été save, impossible d'aller en pause !");}

	}

	public static void revenirPause() {
		File file = new File("fileattente.txt");
		try {
			FileInputStream fis = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fis);
			Context.get_instance().setFileAttente((LinkedList<Patient>) ois.readObject());
			System.out.println("La secretaire revient de pause, toute la file a été TP");
			Context.get_instance().setPause(false);
			ois.close();
			fis.close();

		}catch(Exception e) {System.out.println("Le chargement du fichier a été cancel");}
	}


	public static void showVisite(int secu) 
	{
		List<Visite> visitesPatient = Context.get_instance().getDaoV().selectAllByPatient(secu);
		if(visitesPatient.isEmpty()) 
		{
			System.out.println("Aucune visite pour ce patient");
		}
		else 
		{
			for(Visite v : visitesPatient) 
			{
				System.out.println(v);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		accueil();	
	}
}
