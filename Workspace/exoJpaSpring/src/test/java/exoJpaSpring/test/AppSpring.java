package exoJpaSpring.test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;

import exoJpaSpring.dao.DaoCommande;
import exoJpaSpring.dao.DaoLigneCommande;
import exoJpaSpring.dao.DaoPersonne;
import exoJpaSpring.dao.DaoProduit;
import exoJpaSpring.entity.Client;
import exoJpaSpring.entity.Commande;
import exoJpaSpring.entity.Fournisseur;
import exoJpaSpring.entity.LigneCommande;
import exoJpaSpring.entity.LigneCommandeKey;
import exoJpaSpring.entity.Produit;

public class AppSpring {
	@Autowired
	private DaoProduit daoProduit;
	@Autowired
	private DaoPersonne daoPersonne;
	@Autowired
	private DaoCommande daoCommande;
	@Autowired
	private DaoLigneCommande daoLigneCommande;

	public void run(String[] args) {
		Fournisseur frs = new Fournisseur("aaa", "ppp");

		Produit produit = new Produit("tele", 500);
		produit.setFournisseur(frs);
		daoPersonne.insert(frs);
		daoProduit.insert(produit);

		Client client = new Client("client1", "client1");

		daoPersonne.insert(client);

		Commande commande = new Commande(LocalDate.now(), client);

		daoCommande.insert(commande);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		commande = new Commande(LocalDate.parse("10/08/2020", dtf), client);
		daoCommande.insert(commande);

		LigneCommande lc = new LigneCommande(new LigneCommandeKey(produit, commande), 4);

		daoLigneCommande.insert(lc);

		daoProduit.delete(produit);
	}
}
