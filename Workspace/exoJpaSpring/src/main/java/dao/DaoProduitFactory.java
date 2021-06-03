package dao;

public class DaoProduitFactory {

	private static DaoProduit singleton = null;

	public static DaoProduit getInstance() {
		if (singleton == null) {
			singleton = new DaoProduitJpaSpringImpl();
		}
		return singleton;
	}
}
