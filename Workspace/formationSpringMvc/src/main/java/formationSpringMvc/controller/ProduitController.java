package formationSpringMvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import exoJpaSpring.entity.Produit;
import exoJpaSpring.exceptions.FournisseurException;
import exoJpaSpring.exceptions.ProduitException;
import exoJpaSpring.services.ProduitService;

@Controller
@RequestMapping("/produit")
public class ProduitController {

	@Autowired
	private ProduitService produitService;

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
		return "produit/edit";
	}

	@PostMapping("/save")
	public String save(@ModelAttribute Produit produit) {
		String parametre;
		if (produit.getId() == null) {
			parametre = "create";
		} else {
			parametre = "update";
		}
		try {
			produitService.save(produit);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/produit/list?" + parametre + "=" + produit.getId();
	}

}
