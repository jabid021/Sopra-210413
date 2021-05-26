package formationJpa;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import dao.DaoCommande;
import dao.DaoCommandeFactory;
import dao.DaoLigneCommande;
import dao.DaoLingeCommandeFactory;
import dao.DaoPersonne;
import dao.DaoPersonneFactory;
import dao.DaoProduit;
import dao.DaoProduitFactory;
import entity.Client;
import entity.Commande;
import entity.Fournisseur;
import entity.LigneCommande;
import entity.LigneCommandeKey;
import entity.Produit;

public class App {

    public static void main(String[] args) {

	DaoProduit daoProduit = DaoProduitFactory.getInstance();
	DaoPersonne daoPersonne = DaoPersonneFactory.getInstance();

	Fournisseur frs = new Fournisseur("aaa", "ppp");

	Produit produit = new Produit("tele", 500);
	produit.setFournisseur(frs);
	daoPersonne.insert(frs);
	daoProduit.insert(produit);

	Client client = new Client("client1", "client1");

	daoPersonne.insert(client);

	Commande commande = new Commande(LocalDate.now(), client);
	DaoCommande daoCommande = DaoCommandeFactory.getInstance();

	daoCommande.insert(commande);

	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	commande = new Commande(LocalDate.parse("10/08/2020", dtf), client);
	daoCommande.insert(commande);

	LigneCommande lc = new LigneCommande(new LigneCommandeKey(produit, commande), 4);
	DaoLigneCommande daoLigneCommande = DaoLingeCommandeFactory.getInstance();

	daoLigneCommande.insert(lc);

	daoProduit.delete(produit);
	
    }

}
