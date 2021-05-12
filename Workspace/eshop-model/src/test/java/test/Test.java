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
		//////////
		/*Un object est soit : 
		 * - Transient / New / detached
		 * - Managed par JPA
		 * 
		 * Actions sur les objets : 
		 * 
		 *  persist(p) => p devient managed
		 *  Personne p = em.find(Personne.class,1) => p devient managed
		 *  
		*/
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopModel");
		EntityManager em = emf.createEntityManager();
		
		/////
		em.getTransaction().begin();
		
		
		//Insert
		em.persist(c1);
		c1.setAge(15);
		c1.setPrenom("TOTO");
		
		em.getTransaction().commit();
		
		
		
		//SelectById
		//Client client=em.find(Client.class, 1);
		
		
		
		em.getTransaction().begin();
		
		//Update
		Client client = new Client("Doe", "John", 40, LocalDate.parse("1993-05-01"), new Adresse(6,"Rue rougemont","75009","Paris"));
		client.setId(1);
		Client clientManaged=em.merge(client);
		
		em.remove(clientManaged);
		
		
		
		
		em.getTransaction().commit();
		
		
		em.close();
		emf.close();
	}

	
public void remove(Client c) 
{
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopModel");
	EntityManager em = emf.createEntityManager();
	
	c=em.find(Client.class,c.getId());
	em.remove(c);
	
	//Soit : 
	
	/*
	 * 
	 * 
	c=em.merge(c);
	em.remove(c);
	 * 
	 * */
	 */
	
	em.close();
	emf.close();
}
}

