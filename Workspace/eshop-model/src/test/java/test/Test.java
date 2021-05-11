package test;

import java.time.LocalDate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.Adresse;
import metier.Client;
import metier.Fournisseur;

public class Test {

	public static void main(String[] args) {
		
		Client c1 = new Client("Abid", "Jordan", 28, LocalDate.parse("1993-05-01"), new Adresse(6,"Rue rougemont","75009","Paris"));
		Fournisseur f = new Fournisseur("AJC","Formation","AJC");
		
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopModel");
		EntityManager em = emf.createEntityManager();
		
		
		em.getTransaction().begin();
		
		em.persist(c1);
		em.persist(f);
		
		em.getTransaction().commit();
		
		em.close();
		emf.close();
	}

}
