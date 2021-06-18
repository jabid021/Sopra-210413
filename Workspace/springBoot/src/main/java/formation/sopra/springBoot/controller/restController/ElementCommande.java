package formation.sopra.springBoot.controller.restController;

public class ElementCommande {
	private Integer idProduit;
	private Integer quantite;

	public ElementCommande() {

	}

	public Integer getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(Integer idProduit) {
		this.idProduit = idProduit;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

}
