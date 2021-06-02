package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.metier.Personne;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoPersonneImpl implements DaoPersonne {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Personne findById(Long id) {
		Personne personne = em.find(Personne.class, id);
		return personne;
	}

	@Override
	public List<Personne> findAll() {
		Query myQuery = em.createQuery("SELECT p from Personne p", Personne.class);
		List<Personne> personnes = myQuery.getResultList();
		return personnes;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Personne personne) {
		personne = em.merge(personne);
		em.remove(personne);
	}

	public Personne findByNomAndPrenom(String nom, String prenom) {
		// On est sur d'en avoir qu'un seul

		Query myQuery = em.createQuery("SELECT p from Personne p where p.nom=:nom and p.prenom=:prenom",
				Personne.class);

		myQuery.setParameter("nom", nom);
		myQuery.setParameter("prenom", prenom);

		Personne p = (Personne) myQuery.getSingleResult();
		return p;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Personne object) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne update(Personne object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Personne save(Personne object) {
		// TODO Auto-generated method stub
		return null;
	}

}
