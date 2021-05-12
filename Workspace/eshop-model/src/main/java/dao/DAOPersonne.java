package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Personne;
import util.Context;

public class DAOPersonne implements IDAO<Personne,Integer>{

	@Override
	public Personne findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Personne personne = em.find(Personne.class, id);
		
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT p from Personne p",Personne.class);
		List<Personne> personnes=myQuery.getResultList();
		em.close();
		return personnes;
	}

	@Override
	public Personne save(Personne personne) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		personne = em.merge(personne);
		em.getTransaction().commit();
		
		em.close();
		return personne;
	}

	@Override
	public void delete(Personne personne) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		personne = em.merge(personne);
		em.remove(personne);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Personne findByNomAndPrenom(String nom,String prenom) 
	{
		//On est sur d'en avoir qu'un seul
		
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT p from Personne p where p.nom=:nom and p.prenom=:prenom",Personne.class);
		
		myQuery.setParameter("nom", nom);
		myQuery.setParameter("prenom", prenom);
		
		Personne p =(Personne) myQuery.getSingleResult();
		em.close();
		return p;
	}

}
