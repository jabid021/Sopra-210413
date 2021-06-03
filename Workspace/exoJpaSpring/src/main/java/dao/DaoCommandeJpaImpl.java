package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entity.Commande;
import formationJpa.Context;

public class DaoCommandeJpaImpl implements DaoCommande {

    @Override
    public List<Commande> findAll() {
	List<Commande> commandes = null;
	EntityManager em = Context.getInstance().createEntityManager();
	Query query = em.createQuery("from Commande commande");
	commandes = query.getResultList();
	em.close();
	return commandes;
    }

    @Override
    public Commande findByKey(Integer key) {
	Commande p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	p = em.find(Commande.class, key);
	em.close();
	return p;
    }

    @Override
    public void insert(Commande obj) {
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(obj);
	tx.commit();
	em.close();
    }

    @Override
    public Commande update(Commande obj) {
	Commande commande = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	commande = em.merge(obj);
	tx.commit();
	em.close();
	return commande;
    }

    @Override
    public Commande delete(Commande obj) {
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.remove(em.merge(obj));
	tx.commit();
	em.close();
	return obj;
    }

    @Override
    public Commande deleteByKey(Integer key) {
	Commande commande = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	commande = em.find(Commande.class, key);
	em.remove(commande);
	tx.commit();
	em.close();
	return commande;
    }

}
