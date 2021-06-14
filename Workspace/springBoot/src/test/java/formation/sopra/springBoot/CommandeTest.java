package formation.sopra.springBoot;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import formation.sopra.springBoot.entities.Client;
import formation.sopra.springBoot.entities.Commande;
import formation.sopra.springBoot.entities.LigneCommande;
import formation.sopra.springBoot.entities.LigneCommandeKey;
import formation.sopra.springBoot.entities.Produit;
import formation.sopra.springBoot.exceptions.ClientException;
import formation.sopra.springBoot.exceptions.CommandeException;
import formation.sopra.springBoot.exceptions.FournisseurException;
import formation.sopra.springBoot.exceptions.ProduitException;
import formation.sopra.springBoot.services.CommandeService;
import formation.sopra.springBoot.services.ProduitService;

@SpringBootTest
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

	@Test()
	public void saveSansDate() throws CommandeException, ClientException {
		createCommande(new Commande());

	}

	private Commande createCommande(Commande commande) throws CommandeException, ClientException {
		return commandeService.save(commande);
	}

	private void deleteCommande(Commande commande) {
		commandeService.delete(commande);
	}

	@Test
	public void delete() throws ProduitException, FournisseurException, CommandeException, ClientException {
		Commande commande = createCommande(getCommande());
		assertNotNull(getById(commande.getNumero()));
		assertThrows(CommandeException.class, () -> deleteCommande(commande));
		getById(commande.getNumero());
	}

	@Test
	public void deleteId() throws CommandeException, ProduitException, FournisseurException, ClientException {
		Commande commande = createCommande(getCommande());
		assertNotNull(getById(commande.getNumero()));
		assertThrows(CommandeException.class, () -> commandeService.delete(commande.getNumero()));
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
