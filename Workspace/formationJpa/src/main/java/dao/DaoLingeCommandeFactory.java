package dao;

public class DaoLingeCommandeFactory {

    private static DaoLigneCommande singleton = null;

    public static DaoLigneCommande getInstance() {
	if (singleton == null) {
	    singleton = new DaoLigneCommandeJpaImpl();
	}
	return singleton;
    }
}
