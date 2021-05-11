package test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import metier.Medecin;
import metier.Secretaire;

public class TestJPA {

	public static void main(String[] args) {
		
		Secretaire s = new Secretaire();
		s.setAncien("Tres ancien");
		s.setLogin("logSec");
		s.setPassword("123456789");
		
		Medecin m = new Medecin();
		m.setLogin("log");
		m.setPassword("password");
		m.setSalle(2);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("demoJPA");
		
		EntityManager em = emf.createEntityManager();
		
		em.getTransaction().begin();
		
		em.persist(s);
		em.persist(m);
		
		em.getTransaction().commit();
		
		em.close();
		
		emf.close();
		
		
		
	}

}
