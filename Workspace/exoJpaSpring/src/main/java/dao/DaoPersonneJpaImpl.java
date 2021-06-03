package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entity.Client;
import entity.Fournisseur;
import entity.Personne;
import formationJpa.Context;

class DaoPersonneJpaImpl implements DaoPersonne {

    @Override
    public List<Personne> findAll() {
	List<Personne> list = null;
	EntityManager em = Context.getInstance().createEntityManager();
	Query query = em.createQuery("from Personne p");
	list = query.getResultList();
	em.close();
	return list;
    }

    @Override
    public Personne findByKey(Integer key) {
	Personne p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	p = em.find(Personne.class, key);
//	if (p instanceof Fournisseur) {
//	    System.out.println(((Fournisseur) p).getProduits());
//	}
	em.close();
	return p;
    }

    @Override
    public void insert(Personne obj) {
	EntityManager em = null;
	EntityTransaction tx = null;
	try {
	    em = Context.getInstance().createEntityManager();
	    tx = em.getTransaction();
	    tx.begin();
	    em.persist(obj);
	    tx.commit();
	} catch (Exception ex) {
	    ex.printStackTrace();
	    if (tx != null && tx.isActive()) {
		tx.rollback();
	    }
	} finally {
	    if (em != null && em.isOpen()) {
		em.close();
	    }
	}

    }

    @Override
    public Personne update(Personne obj) {
	Personne p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	p = em.merge(obj);
	tx.commit();
	em.close();
	return p;
    }

    @Override
    public Personne delete(Personne obj) {
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.remove(em.merge(obj));
	tx.commit();
	em.close();
	return obj;
    }

    @Override
    public Personne deleteByKey(Integer key) {
	Personne p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	p = em.find(Personne.class, key);
	em.remove(p);
	tx.commit();
	em.close();
	return p;
    }

    @Override
    public List<Client> findAllClient() {
	EntityManager em = Context.getInstance().createEntityManager();
	Query query = em.createQuery("from Client c");
	List<Client> clients = null;
	clients = query.getResultList();
	em.close();
	return clients;
    }

    @Override
    public List<Fournisseur> findAllFournisseur() {
	EntityManager em = Context.getInstance().createEntityManager();
	Query query = em.createQuery("from Fournisseur f");
	List<Fournisseur> frs = query.getResultList();
	em.close();
	return frs;
    }
}
