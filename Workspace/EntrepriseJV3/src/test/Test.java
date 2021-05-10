package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;

import dao.DAODepartement;
import dao.DAOEmploye;
import metier.Compte;
import metier.Departement;
import metier.Employe;

public class Test {
	
	
	static DAODepartement daoDept = new DAODepartement();
	static DAOEmploye daoEmp = new DAOEmploye();
	
	
	public static void ecrireFichier(String chemin,String message) 
	{

		File f = new File(chemin);
		try(FileWriter fw = new FileWriter(f,true);) {
			fw.write(message);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public static void ecrireSociete(List<Departement> societe) 
	{
		File f = new File("societe.txt");
		try(
				FileOutputStream fos = new FileOutputStream(f);
				ObjectOutputStream oos = new ObjectOutputStream(fos);
			) 
		{
			oos.writeObject(societe);
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static List<Departement> lireSociete()
	{
		File f = new File("societe.txt");
		List<Departement> societe=null;
		
		try(
				FileInputStream fis = new FileInputStream(f);
				ObjectInputStream ois = new ObjectInputStream(fis);
			) 
		{
			societe=(List<Departement>) ois.readObject();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return societe;
	}
	
	
	public static String saisieString(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextLine();
	}

	public static int saisieInt(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextInt();
	}

	public static double saisieDouble(String msg) 
	{
		Scanner sc = new Scanner(System.in);
		System.out.println(msg);
		return sc.nextDouble();
	}
	

	
	
	public static void main(String[] args) {
		menuPrincipal();
	}
	
	private static void menuPrincipal() {
		System.out.println("Appli Entreprise :");
		System.out.println("Faire un choix : ");
		System.out.println("1 - Se connecter");
		System.out.println("2 - Exit");
		
		int choix=  saisieInt("");
		switch(choix) 
		{
		case 1 : seConnecter();break;
		case 2 : System.exit(0);break;
		}
		menuPrincipal();
		
	}

	private static void seConnecter() {
		String login = saisieString("Saisir votre login");
		String password = saisieString("Saisir votre password");
		Compte c=null;
		if(login.equals("admin") && password.equals("admin"))
		{
			String msg=login+" s'est connecté le : "+LocalDateTime.now()+"\n";
			ecrireFichier("connect.txt",msg);
			menuAdmin();
		}
		else if(c instanceof Employe) 
		{
			//PLUS TARD
			menuEmploye();
		}
		else 
		{
			String msg=login+" erreur de connexion le : "+LocalDateTime.now()+"\n";
			ecrireFichier("errorConnect.txt",msg);
			System.out.println("Identifiants invalides");
		}
	}

	private static void menuEmploye() {
		// TODO Auto-generated method stub
		
	}

	private static void menuAdmin() {
		System.out.println("Menu ADMIN : ");
		System.out.println("1 - Gestion employes");
		System.out.println("2 - Gestion departements");
		System.out.println("3 - Deconnexion");
		
		int choix =saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : gestionEmp();break;
		case 2 : gestionDept();break;
		case 3 : menuPrincipal();break;
		}
		
		menuAdmin();
	}

	private static void gestionDept() {
		
		System.out.println("Gestion des départements : ");
		System.out.println("1 - Lister les départements");
		System.out.println("2 - Chercher un département par id");
		System.out.println("3 - Ajouter un département");
		System.out.println("4 - Modifier le nom d'un département");
		System.out.println("5 - Supprimer un département");
		System.out.println("6 - Retour menu Admin");
		
		int choix =saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : showDepartements();break;
		case 2 : showDepartementById();break;
		case 3 : addDepartement();break;
		case 4 : updateDepartement();break;
		case 5 : deleteDepartement();break;
		case 6 : menuPrincipal();break;
		}
		gestionDept();
	}

	private static void showDepartements() {
		System.out.println(daoDept.findAll());
	}



	private static void deleteDepartement() {
		showDepartements();
		
		int id=saisieInt("Id du département à delete");
		
		Departement d = daoDept.findById(id);
		if(d!=null) {
		daoDept.delete(d);}
		else {System.out.println("Departement invalide");}
	}

	private static void updateDepartement() {
		showDepartements();
		
		int id=saisieInt("Id du département à update");
		Departement d = daoDept.findById(id);
		d.setNom(saisieString("Saisir le nom du département"));
		d.setVille(saisieString("Saisir la loc du département"));
		daoDept.update(d);
	}


	private static void addDepartement() {
		int id = saisieInt("Saisir le numéro département");
		String nom = saisieString("Saisir le nom du département");
		String lieu = saisieString("Saisir la loc du département");
		Departement d = new Departement(id,nom,lieu);
		daoDept.insert(d);
	}


	private static void showDepartementById() {
		int id = saisieInt("Saisir l'id d'un département");
		Departement d = daoDept.findById(id);
		System.out.println(d);
		
	}

	
	private static void gestionEmp() 
	{
		
		System.out.println("Gestion des employés : ");
		System.out.println("1 - Lister les employés");
		System.out.println("2 - Chercher un employé par id");
		System.out.println("3 - Créer un nouvel employé");
		System.out.println("4 - Modifier le salaire de l'employé"); 
		System.out.println("5 - Supprimer un employé");
		System.out.println("6 - Retour menu Admin"); 
		
		int choix =saisieInt("Choisir un menu");
		switch(choix) 
		{
		case 1 : showEmployes();break;
		case 2 : showEmployeById();break;
		case 3 : addEmploye();break;
		case 4 : updateEmploye();break;
		case 5 : deleteEmploye();break;
		case 6 : menuAdmin();break;
		} 
		
		gestionEmp();
	}
	
	private static void showEmployes() 
	{
		System.out.println(daoEmp.findAll());
	}

	
	private static void showEmployeById() 
	{
		int id = saisieInt("Saisir l'id d'un employé");
        Employe e = daoEmp.findById(id);
        System.out.println(e);
	}
	

	private static void addEmploye() 
	{
		int id = saisieInt("Saisir l'Id");
		String login = saisieString("Saisir le login"); 
		String password = saisieString("Saisir le password");
		String nom = saisieString("Saisir le nom");
		String poste = saisieString("Saisir le poste");
		double salaire = saisieDouble("Saisir le salaire");
		Double comm=null;
		int idM = saisieInt("Saisissez l'identifiant du manager de ce nouvel employé ?");
		Employe manager = daoEmp.findById(idM);
		String embauche = saisieString("Saisir la date d'embauche"); 
		int idD = saisieInt("Saisissez l'identifiant du département de ce nouvel employé ?");
		Departement departement = daoDept.findById(idD);
		
		Employe e = new Employe(id, login, password, nom, poste, salaire, comm, manager, departement, embauche);
		
		daoEmp.insert(e);
	}

	
	private static void updateEmploye() 
	{
		showEmployes();
		
		int id = saisieInt("Saisir l'Id de l'employé a update");
		Employe e = daoEmp.findById(id);
		
		e.setLogin(saisieString("Saisir le login")); 
		e.setPassword( saisieString("Saisir le password"));
		e.setNom(  saisieString("Saisir le nom"));
		e.setPoste( saisieString("Saisir le poste"));
		e.setSalaire(saisieDouble("Saisir le salaire"));
		e.setComm(saisieDouble("Saisir la comm"));
		
		int idM = saisieInt("Saisissez l'identifiant du manager de cet employé ?");
		Employe updateManager = daoEmp.findById(idM);
		e.setManager(updateManager);
	
		
		e.setEmbauche(saisieString("Saisir la date d'embauche")); 
		
		int idD = saisieInt("Saisissez l'identifiant du département de cet employé ?");
		Departement updateDepartement = daoDept.findById(idD) ;
		e.setDepartement(updateDepartement);
		
		
		
		daoEmp.update(e);
	}
	
	private static void deleteEmploye() 
	{
			showEmployes();
	        int id=saisieInt("Id de l'employe à delete");
	        Employe e = daoEmp.findById(id);
	        daoEmp.delete(e);
	}
}
