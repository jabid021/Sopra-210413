package exoJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exoJpaSpring.entity.Produit;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoProduitJpaSpringImpl implements DaoProduit {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Produit> findAll() {
		List<Produit> produits = null;
		Query query = em.createQuery("from Produit p");
		produits = query.getResultList();
		return produits;
	}

	@Override
	public Produit findByKey(Integer key) {
		Produit p = null;
		p = em.find(Produit.class, key);
		return p;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Produit obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Produit update(Produit obj) {
		Produit p = null;
		p = em.merge(obj);
		return p;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Produit delete(Produit obj) {
		Produit p = null;
		p = em.find(Produit.class, obj.getId());
		p.getLignesCommandes().stream().forEach(lc -> {
			em.remove(lc);
		});

		em.remove(p);
		return obj;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Produit deleteByKey(Integer key) {
		Produit p = null;
		p = em.find(Produit.class, key);
		return delete(p);
	}

}
