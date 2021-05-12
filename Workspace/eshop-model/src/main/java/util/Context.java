package util;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("eshopModel");

	
	
	
	
	
	
	
	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	
	
	
	
	

}
