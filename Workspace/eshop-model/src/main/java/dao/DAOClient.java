package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import metier.Client;
import util.Context;

public class DAOClient implements IDAO<Client,Integer>{

	@Override
	public Client findById(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Client client = em.find(Client.class, id);
		
		em.close();
		return client;
	}

	@Override
	public List<Client> findAll() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT c from Client c",Client.class);
		List<Client> clients=myQuery.getResultList();
		em.close();
		return clients;
	}

	@Override
	public Client save(Client client) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		client = em.merge(client);
		em.getTransaction().commit();
		
		em.close();
		return client;
	}

	@Override
	public void delete(Client client) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		em.getTransaction().begin();
		client = em.merge(client);
		em.remove(client);
		em.getTransaction().commit();
		
		em.close();
	}

	
	public Client findWithAchats(int id) {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT c from Client c join fetch c.achats where c.id=:id",Client.class);
		myQuery.setParameter("id", id);
		Client client=(Client) myQuery.getSingleResult();
		em.close();
		return client;
	}
	
	public List<Client> findAllWithAchats() {
		EntityManager em = Context.get_instance().getEmf().createEntityManager();
		
		Query myQuery = em.createQuery("SELECT  distinct c from Client c  join fetch c.achats",Client.class);
		List<Client> clients=myQuery.getResultList();
		System.out.println(clients.size());
		em.close();
		return clients;
	}
}
