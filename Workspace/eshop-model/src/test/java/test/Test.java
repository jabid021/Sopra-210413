package test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Client;
import metier.Fournisseur;
import metier.Produit;

public class Test {

	public static void main(String[] args) {
		
		Fournisseur f = new Fournisseur("AJC","Formation","AJC");
		Produit p1 = new Produit("Formation Java",3500,f);
		Produit p2 = new Produit("Formation Assembleur",10,f);
		
		Client c1 = new Client("Abid", "Jordan", 28, LocalDate.parse("1993-05-01"), new Adresse(6,"Rue rougemont","75009","Paris"));
		List<Produit> achats=new ArrayList();
		achats.add(p1);
		achats.add(p2);
		
		c1.setAchats(achats);
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopModel");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
	
		em.persist(c1);
		
		em.getTransaction().commit();
		
		
		System.out.println(em.find(Client.class, 1));
		
		em.close();
		emf.close();
	}

}
