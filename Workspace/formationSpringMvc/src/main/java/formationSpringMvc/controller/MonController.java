package formationSpringMvc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import formationSpringMvc.model.Personne;

@Controller
@RequestMapping("/test")
public class MonController {

	@GetMapping({ "", "/" })
	public String homeTest() {
		return "redirect:/test/home";
	}

	@GetMapping("/home")
	public String home(HttpSession session) {
		session.setAttribute("session", "valeur dans la session");
		return "exo/test";
	}

	@GetMapping("/redirect")
	public String redirection(Model model) {
		System.out.println("dans la console");
		// traitements....
		return "redirect:/test/home";
	}

	@RequestMapping("/hello")
	public String hello(Model model,
			@RequestParam(name = "prenom", required = false, defaultValue = "le monde") String prenom,
			@RequestParam(name = "n", required = false, defaultValue = "0") Integer n) {
		model.addAttribute("prenom", prenom);
		model.addAttribute("n", n);
		return "page";
	}

	@PostMapping("/username")
	// @RequestMapping(value = "/username", method = RequestMethod.POST)
	public String exo1(@RequestParam(name = "username", required = false) String username, Model model) {
		model.addAttribute("username", username);
		return "exo/exo1";
	}

	@GetMapping("/username")
	// @RequestMapping(value = "/username", method = RequestMethod.GET)
	public String form() {
		return "exo/form";
	}

	@GetMapping("/id")
	// @RequestMapping("/id")
	public String exo(@RequestParam Integer id, Model model) {
		model.addAttribute("id", id);
		return "exo/id";
	}

	@GetMapping("/personne")
	public String formulairePersonne(Model model) {
		Personne p = new Personne();
		p.setPrenom("olivier");
		model.addAttribute("personne", p);
		return "exo/formPersonne";
	}

	@PostMapping("/personne")
	public String binding(@ModelAttribute Personne personne, Model model) {
		// model.addAttribute("prenom", prenom);
		// model.addAttribute("nom", nom);
//		Personne personne = new Personne();
//		personne.setNom(nom);
//		personne.setPrenom(prenom);
		model.addAttribute("personne", personne);
		return "exo/personne";
	}
}
