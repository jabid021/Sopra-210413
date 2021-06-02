package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.metier.Achat;
import eshop.metier.AchatPK;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoAchatImpl implements DaoAchat {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Achat> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Achat findById(AchatPK id) {
		Achat achat = em.find(Achat.class, id);
		return achat;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Achat save(Achat object) {
		object = em.merge(object);
		return object;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Achat object) {
		em.persist(object);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Achat update(Achat object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Achat object) {
		em.remove(em.merge(object));
	}

}
