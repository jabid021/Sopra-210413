package exoJpaSpring;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

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
import exoJpaSpring.exceptions.ProduitException;
import exoJpaSpring.repositories.FournisseurRepository;
import exoJpaSpring.repositories.ProduitRepositry;
import exoJpaSpring.services.ProduitService;

public class AppSpring {

//	@Autowired
//	private ProduitRepositry produitRepository;
//	@Autowired
//	private FournisseurRepository fournisseurRepository;

	@Autowired
	private ProduitService produitService;

	public void run(String[] args) {
		Produit produit = new Produit();

		try {
			produitService.save(produit);
		} catch (ProduitException e) {
			e.printStackTrace();
		}

		try {
			produitService.save(new Produit("aaa", 200));
		} catch (ProduitException e) {
			e.printStackTrace();
		}
		System.out.println(produitService.getAllProduits());

		try {
			System.out.println(produitService.getById(100));
		} catch (ProduitException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		produit = produitRepository.save(produit);
//
//		System.out.println(produitRepository.findAll());
//		Optional<Produit> opt = produitRepository.findById(111111);
//		if (opt.isPresent()) {
//			System.out.println(opt.get());
//		} else {
//			System.out.println(opt);
//		}
//
//		Fournisseur frs = new Fournisseur("olivier", "gozlan");
//		frs = fournisseurRepository.save(frs);
//
//		produitRepository.saveAll(Arrays.asList(new Produit("tele", -500, frs), new Produit("telephone", 200),
//				new Produit("voitrue", 20000, frs)));
//
//		System.out.println(produitRepository.findAll());
//		produitRepository.setPrixSolde(0.5);
//		System.out.println(produitRepository.findAll());
//		produitRepository.deleteProduitSansFournisseur();
//		System.out.println(produitRepository.findAll());

//		System.out.println(produitRepository.findByNom("tele"));
//		System.out.println(produitRepository.findByNomLike("tele%"));
//		System.out.println(produitRepository.findByNomContaining("tele"));
//		produitRepository.findByNomContainingAndPrixLessThan("te", 1000.0);
//		System.out.println(produitRepository.findByFournisseurIsNull());
//		System.out.println(produitRepository.findByFournisseurIsNotNull());
//		System.out.println("--------------");
//		Optional<Fournisseur> optFournisseur = fournisseurRepository.findByIdWithProduits(frs.getId());
//		if (optFournisseur.isPresent()) {
//			System.out.println(optFournisseur.get().getProduits());
//		}

//		System.out.println(produitRepository.findAll());
//		System.out.println(produitRepository.findAll(Sort.by("prix").descending()));
//
//		Pageable unePage = PageRequest.of(0, 2);
//		Page<Produit> resultat = produitRepository.findAll(unePage);
//		System.out.println(resultat);
//		resultat.get().forEach(System.out::println);
//		System.out.println(produitRepository.findAll(resultat.nextPageable()));

	}

	private void test() {
//		Fournisseur frs = new Fournisseur("aaa", "ppp");
//
//		Produit produit = new Produit("tele", 500);
//		produit.setFournisseur(frs);
//		daoPersonne.insert(frs);
//		daoProduit.insert(produit);
//
//		Client client = new Client("client1", "client1");
//
//		daoPersonne.insert(client);
//
//		Commande commande = new Commande(LocalDate.now(), client);
//
//		daoCommande.insert(commande);
//
//		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
//		commande = new Commande(LocalDate.parse("10/08/2020", dtf), client);
//		daoCommande.insert(commande);
//
//		LigneCommande lc = new LigneCommande(new LigneCommandeKey(produit, commande), 4);
//
//		daoLigneCommande.insert(lc);
//
//		daoProduit.delete(produit);
	}
}
