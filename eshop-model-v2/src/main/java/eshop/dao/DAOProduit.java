package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.metier.Produit;
import util.Context;

public class DAOProduit implements IDAO<Produit, Long>{

    public Produit findById(Long long1)
    {
        EntityManager em = Context.getInstance().getEmf().createEntityManager();
        Produit p = em.find(Produit.class, long1);
        em.close();
        return p;
    }

    public List<Produit> findAll() {
        return null;
    }

    public Produit save(Produit p) {
        EntityManager em = Context.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        p = em.merge(p);
        em.getTransaction().commit();
        em.close();
        return p;
    }

    public void delete(Produit p) {
        EntityManager em = Context.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(p));
        em.getTransaction().commit();
        em.close();
    }

	@Override
	public Produit insert(Produit object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Produit update(Produit object) {
		// TODO Auto-generated method stub
		return null;
	}
}