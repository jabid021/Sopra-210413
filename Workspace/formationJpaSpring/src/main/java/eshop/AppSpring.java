package eshop;

import org.springframework.beans.factory.annotation.Autowired;

import eshop.dao.DaoProduit;
import eshop.metier.Produit;

public class AppSpring {

	@Autowired
	private DaoProduit daoProduit;

	public void run(String[] args) {
		Produit tele = new Produit();
		tele.setLibelle("tele");
		tele.setPrix(500);
		daoProduit.insert(tele);
		System.out.println(daoProduit.findAll());
	}
}
