package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import eshop.metier.Fournisseur;

@Repository
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DaoFournisseurImpl implements DaoFournisseur {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Fournisseur findById(Long long1) {
		Fournisseur fournisseur = em.find(Fournisseur.class, long1);
		return fournisseur;
	}

	public Fournisseur findByIdWithProduit(Long id) {
		TypedQuery<Fournisseur> query = em.createQuery(
				"select distinct f from Fournisseur f left join fetch f.offres where f.id=:id", Fournisseur.class);
		query.setParameter("id", id);
		Fournisseur f = query.getSingleResult();
		return f;
	}

	public List<Fournisseur> findAllWithProduit() {
		TypedQuery<Fournisseur> query = em.createQuery("select distinct f from Fournisseur f left join fetch f.offres",
				Fournisseur.class);

		List<Fournisseur> list = query.getResultList();
		return list;
	}

	@Override
	public List<Fournisseur> findAll() {
		Query myQuery = em.createQuery("SELECT f from Fournisseur f", Fournisseur.class);
		List<Fournisseur> fournisseurs = myQuery.getResultList();
		return fournisseurs;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void delete(Fournisseur fournisseur) {
		fournisseur = em.find(Fournisseur.class, fournisseur.getId());
		fournisseur.getOffres().stream().forEach(p -> {
			p.setFournisseur(null);
			em.merge(p);
		});
		em.remove(fournisseur);
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public void insert(Fournisseur object) {
		// TODO Auto-generated method stub

	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Fournisseur update(Fournisseur object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED, readOnly = false)
	public Fournisseur save(Fournisseur object) {
		object = em.merge(object);
		return object;
	}

}
