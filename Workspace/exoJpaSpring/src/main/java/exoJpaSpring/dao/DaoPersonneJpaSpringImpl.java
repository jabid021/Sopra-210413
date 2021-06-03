package exoJpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import exoJpaSpring.entity.Client;
import exoJpaSpring.entity.Fournisseur;
import exoJpaSpring.entity.Personne;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
class DaoPersonneJpaSpringImpl implements DaoPersonne {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Personne> findAll() {
		List<Personne> list = null;
		Query query = em.createQuery("from Personne p");
		list = query.getResultList();
		return list;
	}

	@Override
	public Personne findByKey(Integer key) {
		Personne p = null;
		p = em.find(Personne.class, key);
//	if (p instanceof Fournisseur) {
//	    System.out.println(((Fournisseur) p).getProduits());
//	}
		return p;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Personne obj) {
		em.persist(obj);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne update(Personne obj) {
		Personne p = null;
		p = em.merge(obj);
		return p;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne delete(Personne obj) {
		em.remove(em.merge(obj));
		return obj;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne deleteByKey(Integer key) {
		Personne p = null;
		p = em.find(Personne.class, key);
		em.remove(p);
		return p;
	}

	@Override
	public List<Client> findAllClient() {
		Query query = em.createQuery("from Client c");
		List<Client> clients = null;
		clients = query.getResultList();
		return clients;
	}

	@Override
	public List<Fournisseur> findAllFournisseur() {
		Query query = em.createQuery("from Fournisseur f");
		List<Fournisseur> frs = query.getResultList();
		return frs;
	}
}
