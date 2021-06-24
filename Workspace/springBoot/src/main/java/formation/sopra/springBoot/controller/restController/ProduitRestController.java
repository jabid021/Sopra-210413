package formation.sopra.springBoot.controller.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.ReflectionUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.entities.Fournisseur;
import formation.sopra.springBoot.entities.Produit;
import formation.sopra.springBoot.entities.views.Views;
import formation.sopra.springBoot.exceptions.ProduitException;
import formation.sopra.springBoot.exceptions.rest.ProduitInvalidException;
import formation.sopra.springBoot.services.FournisseurService;
import formation.sopra.springBoot.services.ProduitService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/produit")
public class ProduitRestController {

	private Logger logger = LoggerFactory.getLogger(ProduitRestController.class);

	@Autowired
	private ProduitService produitService;
	@Autowired
	private FournisseurService fournisseurService;

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

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.ProduitWithFournisseur.class)
	public Produit create(@Valid @RequestBody Produit produit, BindingResult br) {
		if (br.hasErrors()) {
			throw new ProduitInvalidException();
		}
		try {
			produit = produitService.save(produit);
		} catch (Exception e) {
			throw new ProduitInvalidException();
		}
		return produit;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Produit getProduitById(@PathVariable Integer id) {
		return getById(id);

	}

	@GetMapping("/{id}/fournisseur")
	@JsonView(Views.ProduitWithFournisseur.class)
	public Produit getProduitByIdWithFournisseur(@PathVariable Integer id) {
		return getById(id);
	}

	private Produit getById(Integer id) {
		Produit p = null;
		try {
			p = produitService.getById(id);
		} catch (ProduitException e) {
			throw new ProduitInvalidException();
		}
		return p;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		produitService.delete(id);
	}

	@PutMapping("/{id}")
	@JsonView(Views.ProduitWithFournisseur.class)
	public Produit update(@Valid @RequestBody Produit produit, BindingResult br, @PathVariable Integer id) {
		logger.trace(br.toString());
		if (br.hasErrors()) {
			// System.out.println("binding resut");
			logger.trace("binding result");
			throw new ProduitInvalidException();
		}
		produit.setId(id);
		try {
			produit = produitService.save(produit);
		} catch (Exception e) {
			// System.out.println("save");
			logger.trace("save");
			throw new ProduitInvalidException();
		}
		return produit;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.ProduitWithFournisseur.class)
	public Produit update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		try {
			System.out.println(fields);
			final Produit produitEnBase = produitService.getById(id);
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Produit.class, key);
				ReflectionUtils.makeAccessible(field);
				if (key.equals("fournisseur")) {
					System.out.println(((Map) value).get("id"));
//					Fournisseur frs = new Fournisseur();
//					((Map<String, Object>) value).forEach((k, v) -> {
//						Field fieldFrs = ReflectionUtils.findField(Fournisseur.class, k);
//						ReflectionUtils.makeAccessible(fieldFrs);
//						System.out.println(v);
//						ReflectionUtils.setField(fieldFrs, frs, v);

//						if (k.equals("id")) {
//							produitEnBase.setFournisseur(fournisseurService.getById(Integer.parseInt(v.toString())));
//						}
//					});
					// produitEnBase.setFournisseur(frs);
				} else {
					ReflectionUtils.setField(field, produitEnBase, value);
				}
			});
			produitService.save(produitEnBase);
			return produitEnBase;
		} catch (Exception e) {
			e.printStackTrace();
			throw new ProduitInvalidException();
		}

	}
}
