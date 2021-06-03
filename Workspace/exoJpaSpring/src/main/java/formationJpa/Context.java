package formationJpa;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Context {
    private static EntityManagerFactory emf = null;

    public static EntityManagerFactory getInstance() {
	if (emf == null) {
	    emf = Persistence.createEntityManagerFactory("jpa");
	}
	return emf;
    }

    public static void destroy() {
	if (emf != null) {
	    emf.close();
	    emf = null;
	}
    }
}
