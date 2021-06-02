package eshop;

import java.time.LocalDate;

import eshop.dao.DAOClient;
import eshop.dao.DAOFournisseur;
import eshop.dao.DAOProduit;
import eshop.dao.DaoAchat;
import eshop.metier.Achat;
import eshop.metier.AchatPK;
import eshop.metier.Adresse;
import eshop.metier.Client;
import eshop.metier.Fournisseur;
import eshop.metier.Produit;
import util.Context;

public class AppTest {

	public static void main(String[] args) {
		DAOClient daoClient = Context.getInstance().getDaoClient();
		DAOProduit daoProduit = Context.getInstance().getDaoProduit();
		DaoAchat daoAchat = Context.getInstance().getDaoAchat();
		DAOFournisseur daoFournisseur = Context.getInstance().getDaoFournisseur();

		Client client = new Client("gozlan", "olivier", 0, LocalDate.of(1975, 1, 5),
				new Adresse(1, "rue xx", "75000", "paris"));
		client = daoClient.save(client);

		Fournisseur fournisseur = new Fournisseur("aaa", "aaaa", "samsung");
		fournisseur = daoFournisseur.save(fournisseur);
		Produit tele = new Produit("une tele", 1000, fournisseur);
		tele = daoProduit.save(tele);
		
		Produit telephone = new Produit("telephone", 500, fournisseur);
		telephone = daoProduit.save(telephone);
		daoProduit.findById(telephone.getId());

		daoFournisseur.findAllWithProduit().stream().forEach(f->{
			System.out.println(f);
			System.out.println(f.getOffres());
		});

//		Fournisseur recherche = daoFournisseur.findByIdWithProduit(fournisseur.getId());
//		System.out.println(recherche.getOffres());

//		Achat achat = new Achat();
//		achat.setId(new AchatPK(tele, client));
//		achat.setQuantite(3);
//		daoAchat.insert(achat);
//
//		daoFournisseur.delete(fournisseur);
//		
//		client.setNom("aaaaa");
//		client=daoClient.save(client);
//		client.setPrenom("aaaaaaa");
//		client=daoClient.save(client);

		Context.destroy();
	}

}
