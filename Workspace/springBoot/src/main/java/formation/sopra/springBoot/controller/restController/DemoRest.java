package formation.sopra.springBoot.controller.restController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import formation.sopra.springBoot.controller.restController.demo.Entreprise;
import formation.sopra.springBoot.controller.restController.demo.Responsable;

@RestController
@RequestMapping("/api")
public class DemoRest {

	@GetMapping("/hello")
	public String helloWorld(@RequestParam(name = "nom", required = false, defaultValue = "world") String nom) {
		return "hello " + nom;
	}

	@GetMapping("/entreprise")
	public Entreprise getEntreprise() {
		return new Entreprise("ma boite", 1000000, new Responsable("olivier"));
	}

	@GetMapping("/bonjour/{nom}:{prenom}")
	public String hello(@PathVariable String nom, @PathVariable String prenom) {
		return "hello " + prenom + " " + nom;
	}

	@PostMapping("/entreprise")
	public void recupEntreprise(@RequestBody Entreprise entreprise) {
		System.out.println(
				entreprise.getNom() + " " + entreprise.getCapital() + " " + entreprise.getResponsable().getNom());
	}

}
