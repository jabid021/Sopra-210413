package exoServlet.model;

public enum Civilite {
	M("m", "monsieur"), MME("mme", "madame"), MLLE("mlle", "mademoiselle"), DM("dm", "dameoiseau");

	private String ab;

	private String titre;

	private Civilite(String ab, String titre) {
		this.ab = ab;
		this.titre = titre;
	}

	public String getAbreviation() {
		return ab;
	}

	public String getTitre() {
		return titre;
	}
}
