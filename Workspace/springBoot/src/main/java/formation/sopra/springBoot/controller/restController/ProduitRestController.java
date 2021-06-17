package formation.sopra.springBoot.controller.restController;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.entities.Fournisseur;
import formation.sopra.springBoot.entities.Produit;
import formation.sopra.springBoot.entities.views.Views;
import formation.sopra.springBoot.exceptions.rest.ProduitInvalidException;
import formation.sopra.springBoot.services.ProduitService;

@RestController
@RequestMapping("/api/produit")
public class ProduitRestController {

	@Autowired
	private ProduitService produitService;

	@GetMapping("/test")
	public Produit getProduit() {
		Produit p = new Produit("tele", 1000, new Fournisseur("samsung", "samsung"));
		return p;
	}

	@PostMapping("/test")
	@JsonView(Views.Common.class)
	public Produit recupProduit(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProduitInvalidException();
		}
		System.out.println(produit.getFournisseur());
		return produit;
	}

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Produit> getAllProduits() {
		return getAll();
	}

	@GetMapping("/fournisseur")
	@JsonView(Views.ProduitWithFournisseur.class)
	public List<Produit> getAllProduitWithFournisseur() {
		return getAll();
	}

	private List<Produit> getAll() {
		return produitService.getAll();
	}
}
