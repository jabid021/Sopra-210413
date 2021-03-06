package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Client;
import metier.Produit;
import util.Context;

public class DAOProduit implements IDAO<Produit,Integer>{

	@Override
	public Produit findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Produit produit = em.find(Produit.class, id);
		
		em.close();
		return produit;
	}

	@Override
	public List<Produit> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT p from Produit p",Produit.class);
		List<Produit> produits=myQuery.getResultList();
		em.close();
		return produits;
	}

	@Override
	public Produit save(Produit produit) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		produit = em.merge(produit);
		em.getTransaction().commit();
		
		em.close();
		return produit;
	}

	@Override
	public void delete(Produit produit) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		produit = em.merge(produit);
		em.remove(produit);
		em.getTransaction().commit();
		
		em.close();
	}

}
