package formation.sopra.springBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formation.sopra.springBoot.entities.Produit;
import formation.sopra.springBoot.services.FournisseurService;
import formation.sopra.springBoot.services.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;
	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping({ "", "/" })
	public String home() {
		return "redirect:/produit/list";
	}

	@GetMapping("/list")
	public String list(Model model) {
		// getAll()=>mettre dans le modele
		model.addAttribute("produits", produitService.getAll());
		// partir vers la vue qui affiche les produits
		return "produit/list";
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id, Model model) {
		produitService.delete(id);
		return "redirect:/produit/list?delete=" + id;
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		try {
			return goEdit(produitService.getById(id), model);
		} catch (Exception e) {

		}
		return goEdit(new Produit(), model);
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Produit(), model);
	}

	public String goEdit(Produit produit, Model model) {
		model.addAttribute("produit", produit);
		model.addAttribute("fournisseurs", fournisseurService.getAll());
		return "produit/edit";
	}

	@GetMapping("/save")
	public String save(@ModelAttribute @Valid Produit produit, BindingResult bindingResult, Model model) {

		if (bindingResult.hasErrors()) {
			System.out.println(bindingResult);
			return goEdit(produit, model);
		}

		String parametre;
		if (produit.getId() == null) {
			parametre = "create";
		} else {
			parametre = "update";
		}
		if (produit.getFournisseur() != null && produit.getFournisseur().getId() == null) {
			produit.setFournisseur(null);
		}

		try {
			produitService.save(produit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/produit/list?" + parametre + "=" + produit.getId();
	}

}
