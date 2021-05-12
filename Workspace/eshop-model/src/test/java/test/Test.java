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
import util.Context;

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
		//Context.get_instance().getDaoC().save(c1);
		
		
		//Retourne un Client + ses achats
		System.out.println(Context.get_instance().getDaoC().findWithAchats(1));
		
		List<Client> maListe=new ArrayList();
		for(Client c : Context.get_instance().getDaoC().findAll())
		{
			
			maListe.add(Context.get_instance().getDaoC().findWithAchats(c.getId()));
		}
		
		System.out.println(maListe);
		
		//Retourner tous les clients avec leurs achats
		/*for(Client c : Context.get_instance().getDaoC().findAllWithAchats()) 
		{
			System.out.println(c);
		}*/
		
		//Retourne une personne avec ce nom + ce prenom
		System.out.println(Context.get_instance().getDaoPe().findByNomAndPrenom("Formation", "AJC").getId());
		Context.get_instance().getEmf().close();
	}

	
}

