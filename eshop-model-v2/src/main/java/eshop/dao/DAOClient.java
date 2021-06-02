package eshop.dao;

import java.util.List;

import javax.persistence.EntityManager;

import eshop.metier.Client;
import util.Context;

public class DAOClient implements IDAO<Client, Integer>{

    public Client findById(Integer id)
    {
        EntityManager em = Context.getInstance().getEmf().createEntityManager();
        Client c = em.find(Client.class, id);
        em.close();
        return c;
    }

    public List<Client> findAll() {
        return null;
    }

    public Client save(Client c) {
        EntityManager em = Context.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        c = em.merge(c);
        em.getTransaction().commit();
        em.close();
        return c;
    }

    public void delete(Client c) {
        EntityManager em = Context.getInstance().getEmf().createEntityManager();
        em.getTransaction().begin();
        em.remove(em.merge(c));
        em.getTransaction().commit();
        em.close();
    }

	@Override
	public Client insert(Client object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client update(Client object) {
		// TODO Auto-generated method stub
		return null;
	}
}

