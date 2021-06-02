package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import eshop.metier.Fournisseur;
import eshop.metier.Produit;
import util.Context;

public class DAOFournisseur implements IDAO<Fournisseur, Long> {

	@Override
	public Fournisseur findById(Long long1) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Fournisseur fournisseur = em.find(Fournisseur.class, long1);
		// System.out.println(fournisseur.getOffres());
		em.close();
		return fournisseur;
	}

	public Fournisseur findByIdWithProduit(Long id) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		TypedQuery<Fournisseur> query = em
				.createQuery("select distinct f from Fournisseur f left join fetch f.offres where f.id=:id", Fournisseur.class);
		query.setParameter("id", id);
		Fournisseur f = query.getSingleResult();
		em.close();
		return f;
	}

	public List<Fournisseur> findAllWithProduit() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		TypedQuery<Fournisseur> query = em.createQuery("select distinct f from Fournisseur f left join fetch f.offres",
				Fournisseur.class);

		List<Fournisseur> list = query.getResultList();
		em.close();
		return list;
	}

	@Override
	public List<Fournisseur> findAll() {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		Query myQuery = em.createQuery("SELECT f from Fournisseur f", Fournisseur.class);
		List<Fournisseur> fournisseurs = myQuery.getResultList();
		em.close();
		return fournisseurs;
	}

	@Override
	public void delete(Fournisseur fournisseur) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();

		em.getTransaction().begin();
		fournisseur = em.find(Fournisseur.class, fournisseur.getId());

//		fournisseur.getOffres().stream().forEach(System.out::println);
//		fournisseur.getOffres().stream().forEach(p->{
//			System.out.println(p);
//		});
		fournisseur.getOffres().stream().forEach(p -> {
			p.setFournisseur(null);
			em.merge(p);
		});

		em.remove(fournisseur);
		em.getTransaction().commit();

		em.close();
	}

	@Override
	public Fournisseur insert(Fournisseur object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur update(Fournisseur object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Fournisseur save(Fournisseur object) {
		EntityManager em = Context.getInstance().getEmf().createEntityManager();
		em.getTransaction().begin();
		object = em.merge(object);
		em.getTransaction().commit();
		em.close();
		return object;
	}

}
