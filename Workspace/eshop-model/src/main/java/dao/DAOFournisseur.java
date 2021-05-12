package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Fournisseur;
import metier.Personne;
import util.Context;

public class DAOFournisseur implements IDAO<Fournisseur,Integer>{

	@Override
	public Fournisseur findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		Fournisseur fournisseur = em.find(Fournisseur.class, id);

		em.close();
		return fournisseur;
	}

	@Override
	public List<Fournisseur> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		Query myQuery = em.createQuery("SELECT f from Fournisseur f",Fournisseur.class);
		List<Fournisseur> fournisseurs=myQuery.getResultList();
		em.close();
		return fournisseurs;
	}

	@Override
	public Fournisseur save(Fournisseur fournisseur) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		em.getTransaction().begin();
		fournisseur = em.merge(fournisseur);
		em.getTransaction().commit();

		em.close();
		return fournisseur;
	}

	@Override
	public void delete(Fournisseur fournisseur) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();

		em.getTransaction().begin();
		fournisseur = em.merge(fournisseur);
		em.remove(fournisseur);
		em.getTransaction().commit();

		em.close();
	}

}
