package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.metier.Client;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoClientImpl implements DaoClient {

	@PersistenceContext
	private EntityManager em;

	public Client findById(Long id) {
		return em.find(Client.class, id);
	}

	public List<Client> findAll() {
		return null;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Client save(Client c) {
		c = em.merge(c);
		return c;
	}

	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Client c) {
		em.remove(em.merge(c));
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Client object) {
		// TODO Auto-generated method stub
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Client update(Client object) {
		// TODO Auto-generated method stub
		return null;
	}

}
