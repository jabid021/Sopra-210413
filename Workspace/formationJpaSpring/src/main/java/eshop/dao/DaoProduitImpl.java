package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.metier.Produit;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoProduitImpl implements DaoProduit {

	@PersistenceContext
	private EntityManager em;

	public Produit findById(Long long1) {
		Produit p = em.find(Produit.class, long1);
		return p;
	}

	public List<Produit> findAll() {
		return em.createQuery("from Produit p", Produit.class).getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Produit save(Produit p) {
		return em.merge(p);
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Produit p) {
		em.remove(em.merge(p));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Produit object) {
		em.persist(object);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Produit update(Produit object) {
		return em.merge(object);
	}
}