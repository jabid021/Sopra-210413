package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import dao.DAOClient;
import dao.DAOFournisseur;
import dao.DAOPersonne;
import dao.DAOProduit;

public class Context {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopModel");
	
	private DAOProduit daoP = new DAOProduit();
	private DAOClient daoC = new DAOClient();
	private DAOFournisseur daoF = new DAOFournisseur();
	private DAOPersonne daoPe = new DAOPersonne();
	
	private static Context _instance;
	
	
	private Context() {}
	
	
	public DAOProduit getDaoP() {
		return daoP;
	}

	public DAOClient getDaoC() {
		return daoC;
	}


	public DAOPersonne getDaoPe() {
		return daoPe;
	}


	public DAOFournisseur getDaoF() {
		return daoF;
	}

	public static Context get_instance() {
		if(_instance==null) 
		{
			_instance=new Context();
		}
		return _instance;
	}


	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
}
