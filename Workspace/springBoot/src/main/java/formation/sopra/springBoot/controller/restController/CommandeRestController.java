package formation.sopra.springBoot.controller.restController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.config.UtilisateurSpring;
import formation.sopra.springBoot.entities.Client;
import formation.sopra.springBoot.entities.Commande;
import formation.sopra.springBoot.entities.LigneCommande;
import formation.sopra.springBoot.entities.LigneCommandeKey;
import formation.sopra.springBoot.entities.Produit;
import formation.sopra.springBoot.entities.views.Views;
import formation.sopra.springBoot.exceptions.CommandeException;
import formation.sopra.springBoot.services.ClientService;
import formation.sopra.springBoot.services.CommandeService;
import formation.sopra.springBoot.services.ProduitService;

@RestController
@RequestMapping("/api/commande")
public class CommandeRestController {

	@Autowired
	private CommandeService commandeService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private ProduitService produitService;

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("")
	@JsonView(Views.Commande.class)
	public List<Commande> getAllCommande() {
		return getAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/full")
	@JsonView(Views.CommandeWithLigneCommande.class)
	public List<Commande> getAllCommandeWithLigneCommande() {
		return getAll();
	}

	private List<Commande> getAll() {
		return commandeService.getAll();
	}

	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/{id}")
	@JsonView(Views.CommandeWithLigneCommande.class)
	public Commande getById(Integer id) {
		try {
			return commandeService.getById(id);
		} catch (CommandeException e) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND);
		}
	}

	@PreAuthorize("hasAnyRole('USER')")
	@JsonView(Views.CommandeWithLigneCommande.class)
	@GetMapping("/client")
	public List<Commande> getByClient(@AuthenticationPrincipal UtilisateurSpring utilisateurSpring) {
		Client client = clientService.getByIdWithCommandes(utilisateurSpring.getUtilisateur().getClient().getId());
		return client.getCommandes();
	}

	@PostMapping("")
	@PreAuthorize("hasAnyRole('USER')")
	@JsonView(Views.CommandeWithLigneCommande.class)
	public Commande create(@AuthenticationPrincipal UtilisateurSpring utilisateurSpring,
			@RequestBody List<ElementCommande> list) {
		Commande commande = new Commande();
		commande.setClient(utilisateurSpring.getUtilisateur().getClient());
		commande.setDate(LocalDate.now());
		List<LigneCommande> lignes = new ArrayList<LigneCommande>();
		list.forEach(e -> {
			try {
				Produit produit = produitService.getById(e.getIdProduit());
				lignes.add(new LigneCommande(new LigneCommandeKey(produit, commande), e.getQuantite()));
			} catch (Exception e1) {
				throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
			}
		});
		commande.setLignesCommandes(lignes);
		try {
			return commandeService.save(commande);
		} catch (Exception e1) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
		}

	}
}
