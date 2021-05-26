package dao;

public class DaoCommandeFactory {

    private static DaoCommande singleton = null;

    public static DaoCommande getInstance() {
	if (singleton == null) {
	    singleton = new DaoCommandeJpaImpl();
	}
	return singleton;
    }
}
