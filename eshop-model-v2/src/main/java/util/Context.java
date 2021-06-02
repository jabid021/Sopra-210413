package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import eshop.dao.DAOClient;
import eshop.dao.DAOFournisseur;
import eshop.dao.DAOPersonne;
import eshop.dao.DAOProduit;
import eshop.dao.DaoAchat;

public class Context {

	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopModel");
	private DAOProduit daoProduit = new DAOProduit();
	private DAOClient daoClient = new DAOClient();
	private DaoAchat daoAchat = new DaoAchat();
	private DAOFournisseur daoFournisseur=new DAOFournisseur();

	public DAOFournisseur getDaoFournisseur() {
		return daoFournisseur;
	}

	public DAOProduit getDaoProduit() {
		return daoProduit;
	}

	public DAOClient getDaoClient() {
		return daoClient;
	}

	public DaoAchat getDaoAchat() {
		return daoAchat;
	}

	private static Context instance;

	private Context() {
	}

	public static Context getInstance() {
		if (instance == null) {
			instance = new Context();
		}
		return instance;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public static void destroy() {
		if (instance != null) {
			instance.getEmf().close();
			instance = null;
		}
	}

}
