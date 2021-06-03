package exoJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exoJpaSpring.entity.Commande;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoCommandeJpaSpringImpl implements DaoCommande {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Commande> findAll() {
		List<Commande> commandes = null;
		Query query = em.createQuery("from Commande commande");
		commandes = query.getResultList();
		return commandes;
	}

	@Override
	public Commande findByKey(Integer key) {
		Commande p = null;
		p = em.find(Commande.class, key);
		return p;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Commande obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Commande update(Commande obj) {
		Commande commande = null;
		commande = em.merge(obj);
		return commande;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Commande delete(Commande obj) {
		em.remove(em.merge(obj));
		return obj;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Commande deleteByKey(Integer key) {
		Commande commande = null;
		commande = em.find(Commande.class, key);
		em.remove(commande);
		return commande;
	}

}
