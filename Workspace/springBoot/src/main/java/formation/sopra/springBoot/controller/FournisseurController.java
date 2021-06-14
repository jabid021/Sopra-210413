package formation.sopra.springBoot.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import formation.sopra.springBoot.entities.Civilite;
import formation.sopra.springBoot.entities.Fournisseur;
import formation.sopra.springBoot.exceptions.FournisseurException;
import formation.sopra.springBoot.services.FournisseurService;

@Controller
@RequestMapping("/fournisseur")
public class FournisseurController {

	@Autowired
	private FournisseurService fournisseurService;

	@GetMapping({ "", "/" })
	public String home() {
		return "redirect:/fournisseur/list";
	}

	@GetMapping("/list")
//	public String list(Model model) {
//		model.addAttribute("fournisseurs", fournisseurService.getAll());
//		return "fournisseur/list";
//	}

	public ModelAndView list() {
		ModelAndView modelAndView = new ModelAndView("fournisseur/list");
		modelAndView.addObject("fournisseurs", fournisseurService.getAll());
		return modelAndView;
	}

	@GetMapping("/delete")
	public String delete(@RequestParam Integer id) {
		fournisseurService.delete(id);
		return "redirect:/fournisseur/list";
	}

	@GetMapping("/edit")
	public String edit(@RequestParam Integer id, Model model) {
		return goEdit(fournisseurService.getById(id), model);
	}

	public String goEdit(Fournisseur fournisseur, Model model) {
		model.addAttribute("fournisseur", fournisseur);
		model.addAttribute("civilites", Civilite.values());
		return "fournisseur/edit";
	}

	@GetMapping("/add")
	public String add(Model model) {
		return goEdit(new Fournisseur(), model);
	}

	@PostMapping("/save")
	public String save(@ModelAttribute("fournisseur") @Valid Fournisseur fournisseur, BindingResult br, Model model) {
		if (br.hasErrors()) {
			return goEdit(fournisseur, model);
		}
		try {
			fournisseurService.save(fournisseur);
		} catch (FournisseurException e) {
			e.printStackTrace();
		}
		return "redirect:/fournisseur/list";
	}
}
