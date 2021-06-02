package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import eshop.metier.Personne;
import util.Context;

public class DAOPersonne implements IDAO<Personne,Integer>{

	@Override
	public Personne findById(Integer id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Personne personne = em.find(Personne.class, id);
		
		em.close();
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT p from Personne p",Personne.class);
		List<Personne> personnes=myQuery.getResultList();
		em.close();
		return personnes;
	}


	@Override
	public void delete(Personne personne) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		personne = em.merge(personne);
		em.remove(personne);
		em.getTransaction().commit();
		
		em.close();
	}
	
	public Personne findByNomAndPrenom(String nom,String prenom) 
	{
		//On est sur d'en avoir qu'un seul
		
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT p from Personne p where p.nom=:nom and p.prenom=:prenom",Personne.class);
		
		myQuery.setParameter("nom", nom);
		myQuery.setParameter("prenom", prenom);
		
		Personne p =(Personne) myQuery.getSingleResult();
		em.close();
		return p;
	}

	@Override
	public Personne insert(Personne object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne update(Personne object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Personne save(Personne object) {
		// TODO Auto-generated method stub
		return null;
	}

}
