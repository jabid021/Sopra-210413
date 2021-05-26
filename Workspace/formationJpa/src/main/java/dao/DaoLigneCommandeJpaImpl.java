package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entity.Commande;
import entity.LigneCommande;
import entity.LigneCommandeKey;
import formationJpa.Context;

public class DaoLigneCommandeJpaImpl implements DaoLigneCommande{

    @Override
    public List<LigneCommande> findAll() {
	List<LigneCommande> lc = null;
	EntityManager em = Context.getInstance().createEntityManager();
	Query query = em.createQuery("from LigneCommande lc");
	lc = query.getResultList();
	em.close();
	return lc;
    }

    @Override
    public LigneCommande findByKey(LigneCommandeKey key) {
	LigneCommande lc = null;
	EntityManager em = Context.getInstance().createEntityManager();
	lc = em.find(LigneCommande.class, key);
	em.close();
	return lc;
    }

    @Override
    public void insert(LigneCommande obj) {
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(obj);
	tx.commit();
	em.close();
    }

    @Override
    public LigneCommande update(LigneCommande obj) {
	LigneCommande lc = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	lc = em.merge(obj);
	tx.commit();
	em.close();
	return lc;
    }

    @Override
    public LigneCommande delete(LigneCommande obj) {
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.remove(em.merge(obj));
	tx.commit();
	em.close();
	return obj;
    }

    @Override
    public LigneCommande deleteByKey(LigneCommandeKey key) {
	LigneCommande lc = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	lc = em.find(LigneCommande.class, key);
	em.remove(lc);
	tx.commit();
	em.close();
	return lc;
    }

}
