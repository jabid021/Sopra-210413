package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.metier.Achat;
import eshop.metier.AchatPK;
import util.Context;

public class DaoAchat implements IDAO<Achat, AchatPK>{

	@Override
	public List<Achat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Achat findById(AchatPK id) {
		 EntityManager em = Context.getInstance().getEmf().createEntityManager();
	        Achat achat = em.find(Achat.class, id);
	        em.close();
	        return achat;
	}

	  public Achat save(Achat object) {
	        EntityManager em = Context.getInstance().getEmf().createEntityManager();
	        em.getTransaction().begin();
	        object = em.merge(object);
	        em.getTransaction().commit();
	        em.close();
	        return object;
	    }

	   
	
	@Override
	public Achat insert(Achat object) {
		 EntityManager em = Context.getInstance().getEmf().createEntityManager();
	        em.getTransaction().begin();
	        System.out.println(object);
	        em.persist(object);
	        em.getTransaction().commit();
	        em.close();
	        return object;
	}

	@Override
	public Achat update(Achat object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Achat object) {
		  EntityManager em = Context.getInstance().getEmf().createEntityManager();
	        em.getTransaction().begin();
	        em.remove(em.merge(object));
	        em.getTransaction().commit();
	        em.close();
	}

}
