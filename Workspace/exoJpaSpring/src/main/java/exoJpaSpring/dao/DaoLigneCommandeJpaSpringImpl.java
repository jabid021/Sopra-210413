package exoJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exoJpaSpring.entity.LigneCommande;
import exoJpaSpring.entity.LigneCommandeKey;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoLigneCommandeJpaSpringImpl implements DaoLigneCommande {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<LigneCommande> findAll() {
		List<LigneCommande> lc = null;
		Query query = em.createQuery("from LigneCommande lc");
		lc = query.getResultList();
		return lc;
	}

	@Override
	public LigneCommande findByKey(LigneCommandeKey key) {
		LigneCommande lc = null;
		lc = em.find(LigneCommande.class, key);
		return lc;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(LigneCommande obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public LigneCommande update(LigneCommande obj) {
		LigneCommande lc = null;
		lc = em.merge(obj);
		return lc;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public LigneCommande delete(LigneCommande obj) {
		em.remove(em.merge(obj));
		return obj;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public LigneCommande deleteByKey(LigneCommandeKey key) {
		LigneCommande lc = null;
		lc = em.find(LigneCommande.class, key);
		em.remove(lc);
		return lc;
	}

}
