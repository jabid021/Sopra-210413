package exoJpaSpring.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import exoJpaSpring.config.AppConfig;
import exoJpaSpring.entity.Client;
import exoJpaSpring.entity.Commande;
import exoJpaSpring.entity.LigneCommande;
import exoJpaSpring.entity.LigneCommandeKey;
import exoJpaSpring.entity.Produit;
import exoJpaSpring.exceptions.ClientException;
import exoJpaSpring.exceptions.CommandeException;
import exoJpaSpring.exceptions.FournisseurException;
import exoJpaSpring.exceptions.ProduitException;
import exoJpaSpring.services.CommandeService;
import exoJpaSpring.services.ProduitService;

import static org.junit.Assert.*;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.junit.Test;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = AppConfig.class)
@Rollback(true)
public class CommandeTest {// extends AbstractTransactionalJUnit4SpringContextTests {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ProduitService produitService;

	private Commande getCommande() throws ProduitException, FournisseurException {
		Commande commande = new Commande();
		commande.setDate(LocalDate.of(2020, Month.JUNE, 3));
		commande.setClient(new Client("olivier", "gozlan"));

		Produit tele = new Produit("tele", 200);
		produitService.save(tele);
		Produit telephone = new Produit("telephone", 100);
		produitService.save(telephone);
		//// @formatter:off
		commande.setLignesCommandes(
				Arrays.asList(
					new LigneCommande(
							new LigneCommandeKey(telephone, commande), 2),
					new LigneCommande(
							new LigneCommandeKey(tele, commande), 1)));
		// @formatter:on
		return commande;

	}

	@Test
	public void saveOk() throws CommandeException, ClientException, ProduitException, FournisseurException {
		Commande commande = createCommande(getCommande());
		assertNotNull(getById(commande.getNumero()));
	}

	@Test(expected = CommandeException.class)
	public void saveSansDate() throws CommandeException, ClientException {
		createCommande(new Commande());

	}

	private Commande createCommande(Commande commande) throws CommandeException, ClientException {
		return commandeService.save(commande);
	}

	private void deleteCommande(Commande commande) {
		commandeService.delete(commande);
	}

	@Test(expected = CommandeException.class)
	public void delete() throws ProduitException, FournisseurException, CommandeException, ClientException {
		Commande commande = createCommande(getCommande());
		assertNotNull(getById(commande.getNumero()));
		deleteCommande(commande);
		getById(commande.getNumero());
	}

	@Test(expected = CommandeException.class)
	public void deleteId() throws CommandeException, ProduitException, FournisseurException, ClientException {
		Commande commande = createCommande(getCommande());
		assertNotNull(getById(commande.getNumero()));
		commandeService.delete(commande.getNumero());
		getById(commande.getNumero());
	}

	private Commande getById(Integer numero) throws CommandeException {
		return commandeService.getById(numero);
	}

	@Test
	public void getAll() throws ProduitException, FournisseurException, CommandeException, ClientException {
		createCommande(getCommande());
		createCommande(getCommande());
		assertNotNull(commandeService.getAll());
	}

	@Test
	public void getId() throws CommandeException, ProduitException, FournisseurException, ClientException {
		Commande commande = createCommande(getCommande());
		assertNotNull(getById(commande.getNumero()));
	}

}
