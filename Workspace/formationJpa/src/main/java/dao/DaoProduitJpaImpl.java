package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entity.LigneCommande;
import entity.Produit;
import formationJpa.Context;

public class DaoProduitJpaImpl implements DaoProduit {

    @Override
    public List<Produit> findAll() {
	List<Produit> produits = null;
	EntityManager em = Context.getInstance().createEntityManager();
	Query query = em.createQuery("from Produit p");
	produits = query.getResultList();
	em.close();
	return produits;
    }

    @Override
    public Produit findByKey(Integer key) {
	Produit p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	p = em.find(Produit.class, key);
	em.close();
	return p;
    }

    @Override
    public void insert(Produit obj) {
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	em.persist(obj);
	tx.commit();
	em.close();
    }

    @Override
    public Produit update(Produit obj) {
	Produit p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	p = em.merge(obj);
	tx.commit();
	em.close();
	return p;
    }

    @Override
    public Produit delete(Produit obj) {
	Produit p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	System.out.println("-------find----------");
	p = em.find(Produit.class, obj.getId());
	//p = em.merge(obj);
	System.out.println("---------list----------");
	System.out.println(p.getLignesCommandes());
	p.getLignesCommandes().stream().forEach(lc -> {
	    System.out.println(lc);
	    em.remove(lc);
	});
	
	em.remove(p);
	tx.commit();
	em.close();
	return obj;
    }

    @Override
    public Produit deleteByKey(Integer key) {
	Produit p = null;
	EntityManager em = Context.getInstance().createEntityManager();
	EntityTransaction tx = em.getTransaction();
	tx.begin();
	p = em.find(Produit.class, key);
	em.remove(p);
	tx.commit();
	em.close();
	return p;
    }

}
