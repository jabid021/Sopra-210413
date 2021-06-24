package formation.sopra.springBoot.controller.restController;

import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

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
import org.springframework.web.server.ResponseStatusException;

import com.fasterxml.jackson.annotation.JsonView;

import formation.sopra.springBoot.entities.Fournisseur;
import formation.sopra.springBoot.entities.views.Views;
import formation.sopra.springBoot.exceptions.FournisseurException;
import formation.sopra.springBoot.exceptions.rest.FournisseurInvalidException;
import formation.sopra.springBoot.exceptions.rest.ProduitInvalidException;
import formation.sopra.springBoot.services.FournisseurService;

@RestController
@RequestMapping("/api/fournisseur")
@CrossOrigin(origins = "*")
public class FournisseurRestController {
	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping("")
	@JsonView(Views.Common.class)
	public List<Fournisseur> getAllProduits() {
		return getAll();
	}

	@GetMapping("/produit")
	@JsonView(Views.FournisseurWithProduits.class)
	public List<Fournisseur> getAllWithProduits() {
		return getAll();
	}

	private List<Fournisseur> getAll() {
		return fournisseurService.getAll();
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("")
	@JsonView(Views.Common.class)
	public Fournisseur create(Fournisseur fournisseur, BindingResult br) {
		if (br.hasErrors()) {
			throw new FournisseurInvalidException();
		}
		try {
			fournisseur = fournisseurService.save(fournisseur);
		} catch (FournisseurException e) {
			throw new FournisseurInvalidException();
		}
		return fournisseur;
	}

	@GetMapping("/{id}")
	@JsonView(Views.Common.class)
	public Fournisseur getFournisseurById(@PathVariable Integer id) {
		return getById(id);
	}

	@GetMapping("/{id}/produit")
	@JsonView(Views.FournisseurWithProduits.class)
	public Fournisseur getFournisseurWithProduitsById(Integer id) {
		return getById(id);
	}

	private Fournisseur getById(Integer id) {
		Fournisseur f = fournisseurService.getById(id);

		if (f.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "fournisseur inconnu");
		}
		return f;
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer id) {
		fournisseurService.delete(id);
	}

	@PutMapping("/{id}")
	@JsonView(Views.Common.class)
	public Fournisseur update(@Valid @RequestBody Fournisseur fournisseur, BindingResult br, @PathVariable Integer id) {
		if (br.hasErrors()) {
			throw new FournisseurInvalidException();
		}
		fournisseur.setId(id);
		try {
			fournisseur = fournisseurService.save(fournisseur);
		} catch (FournisseurException e) {
			throw new FournisseurInvalidException();
		}
		return fournisseur;
	}

	@PatchMapping("/{id}")
	@JsonView(Views.Common.class)
	public Fournisseur update(@RequestBody Map<String, Object> fields, @PathVariable Integer id) {
		final Fournisseur frsEnBase = fournisseurService.getById(id);
		if (frsEnBase.getId() == null) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "fournisseur inconnu");
		}
		fields.forEach((key, value) -> {
			Field field = ReflectionUtils.findField(Fournisseur.class, key);
			ReflectionUtils.makeAccessible(field);
			ReflectionUtils.setField(field, frsEnBase, value);
		});
		try {
			fournisseurService.save(frsEnBase);
		} catch (FournisseurException e) {
			throw new ProduitInvalidException();
		}
		return frsEnBase;
	}

}
